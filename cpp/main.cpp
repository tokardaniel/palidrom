#include <iostream>
#include <ctime>
#include <string.h>
#include <algorithm>
#include <chrono>
#include <iomanip>

using namespace std;
using namespace std::chrono;

time_t parseDateTime(const char* dateTimeString, const char* format);
string DateTime(time_t time, const char* format);
bool isPalidrom(string &date);
string get_reversed_date(string &date);

int main()
{
    const char* datetimeString = "20220101000001";
    const char* format = "%Y%m%d%H%M%S";
    time_t parsedTime = parseDateTime(datetimeString, format);
    tm *ltm = localtime(&parsedTime);
    int results = 0;

    // start time
    auto start = high_resolution_clock::now();

    do {
        ltm->tm_sec += 1;
        time_t next = mktime(ltm);
        ltm = localtime(&next);

        string formatted_date_time = DateTime(next, format);

        bool palidrom = isPalidrom(formatted_date_time);

        if (palidrom == true) {
            cout << formatted_date_time << endl;
            results += 1;
        }
    }
    while (1900 + ltm->tm_year == 2022);

    // end time
    auto stop = high_resolution_clock::now();

    auto duration = duration_cast<seconds>(stop - start);

    cout << "Time taken by function: " << duration.count() << " seconds" << endl;

    cout << "Results: " << results << endl;

    return 0;
}

// function to parse a date or time string
time_t parseDateTime(const char* dateTimeString, const char* format)
{
    tm t = {};
    istringstream ss(dateTimeString);
    ss >> get_time(&t, format);

    if (ss.fail()) {
        cerr << "Date parsing failed!" << endl;
        return 1;
    }

    return mktime(&t);
}


// function to format a time_t value into a date or time string
string DateTime(time_t time, const char* format)
{
    char buffer[30];
    struct tm* timeinfo = localtime(&time);
    strftime(buffer, sizeof(buffer), format, timeinfo);

    string str(buffer);
    return str;
}

// check date is a palidrom
bool isPalidrom(string &date)
{
    string reversed_date = get_reversed_date(date);

    if (reversed_date == date) {
        return true;
    }

    return false;
}

string get_reversed_date(string &date)
{
    string new_date = date;
    reverse(new_date.begin(), new_date.end());

    return new_date;
}
