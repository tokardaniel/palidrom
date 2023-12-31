import datetime

def palindrom_e(date_time):
    datum_str = str(date_time).replace('-', '').replace(' ','').replace(':','')
    return datum_str == datum_str[::-1]

elotte = datetime.datetime.now()
aktualis_ido = datetime.datetime(2022, 1, 1, 0, 0, 1)
palindrom_idopontok_szama = 0
while aktualis_ido.year == 2022:
    if palindrom_e(aktualis_ido):
        print(aktualis_ido)
        palindrom_idopontok_szama += 1
    aktualis_ido += datetime.timedelta(seconds=1)
print(f'Palindorom másodpercek száma 2022-ben: {palindrom_idopontok_szama}')
print(f'A keresés {datetime.datetime.now()-elotte} ideig tartott.')
