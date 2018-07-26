import json

with open('data/book.json', 'r', encoding='utf-8', errors='ignore') as file:
    str = file.read()
    j = json.loads(str)
    for row in j:
        id = row['id']
        title = row['title']
        print("[%s] id : %s title : %s" % ("oldbook", id, title))

with open('data/newbook.json', 'r', encoding='utf-8', errors='ignore') as file:
    str2 = file.read()
    j2 = json.loads(str)
    for row in j2:
        id = row['id']
        title = row['title']
        print("[%s] id : %s title : %s" % ("newbook", id, title))
