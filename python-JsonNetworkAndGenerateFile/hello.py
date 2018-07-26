import json
from urllib import parse, request
from io import BytesIO
from PIL import Image

textmod = {"jsonrpc": "2.0", "method": "user.login", "params": {
    "user": "admin", "password": "zabbix"}, "auth": None, "id": 1}
textmod = json.dumps(textmod).encode(encoding='utf-8')

header_dict = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko', "Content-Type": "application/json"}

appid = "appid"
appsecret = "appsecret"

url = 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=' + \
    appid + '&secret=' + appsecret


req = request.Request(url=url, data=textmod, headers=header_dict)
res = request.urlopen(req)
res = res.read()

r = res.decode(encoding='utf-8')

print(res.decode(encoding='utf-8'))

data = json.loads(r)

print(data['access_token'])
accesstoken = data['access_token']

f = open('accesstoken.txt', 'w')
f.write(res.decode(encoding='utf-8'))
f.close


# 小程序二维码

# erparam = {"path": "/dex", "width": 430,
#            "auto_color": True, "is_hyaline": False}
# erparam = json.dumps(erparam).encode(encoding='utf-8')


def print_img(path, name):
    erurl = "https://api.weixin.qq.com/wxa/getwxacode?access_token=" + accesstoken
    erparam = {"path": "/dex", "width": 430,
               "auto_color": True, "is_hyaline": False}
    erparam = json.dumps(erparam).encode(encoding='utf-8')
    req = request.Request(url=erurl, data=erparam, headers=header_dict)
    res = request.urlopen(req)
    res = res.read()
    image = Image.open(BytesIO(res))
    imagename = "E:\\workspace\\pythongame\\erimg\\" + name + ".png"
    image.save(imagename)


print_img("imagename", "1")

# f = res.decode(encoding='utf-8')

# print(res.decode(encoding='utf-8'))
