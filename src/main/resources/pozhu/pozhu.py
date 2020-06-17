#encoding=utf-8
import requests as req
import re
import traceback
import os
import lxml.html as HTML
import time
from random import randint
import http.client
# http.client.HTTPConnection.debuglevel=1
import json
import codecs

sess = req.session()
def download_page(url, ref=None):
    # headers = {'User-Agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36',
    #         'Referer': ref if ref is not None else 'https://pc.pozhu.com/detail/p_5c40255374cf6_jyaZrMUk/6'}

    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36',
               'Accept': 'text/html, application/xhtml+xml, application/xml; q=0.9, */*; q=0.8',
               'Accept-Encoding': 'gzip, deflate',
               'Cache - Control': 'max - age = 0',
               'Connection': 'Keep-Alive',
               'App-Id': 'appn7n2xNJL4210',
               'Referer': ref if ref is not None else 'https://pc.pozhu.com/detail/p_5c79dcc76621c_e3pSKrZ3/6',
               'Host': 'pc.pozhu.com'}

    cookies = get_cookies()
    try:
        if ref is None:
            c = sess.get(url, headers=headers, cookies=cookies, timeout=10).content
        else:
            c = sess.get(url, headers=headers,timeout=10).content

    except:
        print(traceback.print_exc())
        return None

    dur = randint(1,8)
    time.sleep(dur)
    return c

def get_cookies():
    # s = 'Hm_lvt_ea41f8e8649861379ed632abed12f208=1590406702; Hm_lpvt_ea41f8e8649861379ed632abed12f208=1590406702; anonymous_user_key=dV9hbm9ueW1vdXNfNWVjYmFlNDEyMGE2Zl9zMUV6MHNQM3BQ; dataUpJssdkCookie={"wxver":"","net":"","sid":""}; pc_user_key=2f4640ef7c191159974ec02d9dad57c9; userInfo={"app_id":"appn7n2xNJL4210","user_id":"u_5c4a5b1292ac0_AhsCnwcDDt","wx_name":"宏宇","wx_nickname":"宏宇","wx_avatar":"http://wechatavator-1252524126.file.myqcloud.com/appn7n2xNJL4210/image/compress/u_5c4a5b1292ac0_AhsCnwcDDt.png","wx_gender":1,"birth":null,"address":null,"job":null,"company":null,"wx_account":"","phone":"18810539359","pc_user_key":"2f4640ef7c191159974ec02d9dad57c9"}; app_id="appn7n2xNJL4210"'

    s = 'Hm_lvt_ea41f8e8649861379ed632abed12f208=1590374983; anonymous_user_key=dV9hbm9ueW1vdXNfNWVjYjMyYmQ5OGVjNF9sRWNBTlE1VXM0; dataUpJssdkCookie={"wxver":"","net":"","sid":""}; Hm_lpvt_ea41f8e8649861379ed632abed12f208=1590667316; app_id="appn7n2xNJL4210"; pc_user_key=bd30e4ccbc3576d91f6995698af3cb6e; userInfo={"app_id":"appn7n2xNJL4210","user_id":"u_5c4a5b1292ac0_AhsCnwcDDt","wx_name":"宏宇","wx_nickname":"test","wx_avatar":"http://wechatavator-1252524126.file.myqcloud.com/appn7n2xNJL4210/image/compress/u_5c4a5b1292ac0_AhsCnwcDDt.png","wx_gender":1,"birth":null,"address":null,"job":null,"company":null,"wx_account":"","phone":"18810539359","pc_user_key":"bd30e4ccbc3576d91f6995698af3cb6e"}'

    # s = s1.encode("utf-8")
    res = {}

    for ele in s.split(';'):
        ele = ele.strip()

        sl = ele.split('=')
        k = sl[0]

        v = '='.join(sl[1:])

        res[k] = v.encode("utf-8").decode('latin-1')

    return res

def get_post_data(url, post_data,ref=None):
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36',
               'Accept': 'application/json, text/plain, */*',
               'Accept-Encoding': 'gzip, deflate, br',
               'Accept-Language': 'zh-CN,zh;q=0.9',
               'Connection': 'Keep-Alive',
               'Content-Length': '108',
               'App-Id': 'appn7n2xNJL4210',
               'Content-Type': 'application/json;charset=UTF-8',
               'Referer': ref if ref is not None else 'https://pc.pozhu.com/detail/p_5c79dcc76621c_e3pSKrZ3/6',
               'Origin': 'https://pc.pozhu.com',
               'Sec-Fetch-Mode': 'cors',
               'Sec-Fetch-Site': 'same-origin',
               'Host': 'pc.pozhu.com'}
    cookies = get_cookies()
    # print(cookies)  ref if ref is not None else 'https://pc.pozhu.com/detail/p_5c40255374cf6_jyaZrMUk/6'
    # data_str = '{"page_size":20,"goods_id":"p_5c40255374cf6_jyaZrMUk","last_id":"","goods_type":6,"resource_type":[1,2,3,4]}'
    # post_data = data_str.encode('utf-8').decode('latin-1')
    # json_data = json.loads(data_str)
    # url = "https://pc.pozhu.com/api/xe.goods.relation.get/1.0.0?app_id=appn7n2xNJL4210"

    # c = sess.post(url=url, hearders=headers,data=json_data)
    c = req.post(url,headers=headers, cookies=cookies, data=post_data)
    return c

#### save_folder_path 要保存的文件夹
#### product_id  示例 https://pc.pozhu.com/detail/p_5b3d756f6a32c_A6P6U2xR/6 中的 p_5b3d756f6a32c_A6P6U2xR


# res = requests.get('https://static.pandateacher.com/Over%20The%20Rainbow.mp3')

# music = res.content

# with open(r'c:/Users/Administrator/Desktop/ceshi.mp3', 'ab') as file: #保存到本地的文件名
# file.write(res.content)
# file.flush()


def get_goods_list(product_id, save_folder_path):
    last_id = ""
    prior_last_id = "initial"
    # while last_id not in detail_set:
    while last_id != prior_last_id:
        data_str = '{"page_size":20,"goods_id":"%s","last_id":"%s","goods_type":6,"resource_type":[1,2,3,4]}'%(product_id,last_id)
        post_data = data_str.encode('utf-8').decode('latin-1')
        url = "https://pc.pozhu.com/api/xe.goods.relation.get/1.0.0?app_id=appn7n2xNJL4210"
        refer = "https://pc.pozhu.com/detail/%s/6"%(product_id)
        c = get_post_data(url, post_data, ref=refer)
        dur = randint(1,3)
        time.sleep(dur)
        if c.status_code == 200:
            response_data = json.loads(c.text.encode('utf-8'))
            print(response_data)
            goods_list = response_data["data"]["goods_list"]
            if len(goods_list) == 0:
                prior_last_id = last_id
            for ele in goods_list:
                print(len(goods_list))
                print("order: %s"%(goods_list.index(ele)))
                if goods_list.index(ele) + 1 == len(goods_list):
                    prior_last_id = last_id
                    last_id = ele["resource_id"]

                detail_interface_url = "https://pc.pozhu.com/api/xe.goods.detail.get/2.0.0?app_id=appn7n2xNJL4210"
                tmp_data_str = '{"goods_id":"%s","goods_type":2}'%(ele["resource_id"])
                tmp_post_data = tmp_data_str.encode('utf-8').decode('latin-1')
                tmp_refer = 'https://pc.pozhu.com' + ele["redirect_url"]
                dur = randint(2,5)
                time.sleep(dur)
                tmp_c = get_post_data(detail_interface_url,tmp_post_data, tmp_refer)
                if tmp_c.status_code == 200:
                    print("Startxxxxxxxxxxxxxxxxxxxxxxxxx")
                    print(refer)
                    # print(tmp_c.text.encode('utf-8'))
                    process_detail_json( save_folder_path,tmp_c.text, tmp_refer)

                    print("Endxxxxxxxxxxxxxxxxxxxxxxxxx")
                else:
                    save_item_to_file(os.path.join(save_folder_path, "failed_url.txt"), tmp_refer + "\n")


def process_detail_json(save_folder_path, json_str, detail_url):
    print(json_str)
    detail_dict = json.loads(json_str)["data"]

    try:
        if detail_dict is not None:
            save_item_to_file(os.path.join(save_folder_path, detail_dict["title"] + ".json"), json.dumps(detail_dict))
        else:
            save_item_to_file(os.path.join(save_folder_path, "failed_url.txt"), detail_url + "\n")

    except:
        print(traceback.print_exc())
        return None



def save_item_to_file(filename, item):
    with codecs.open(filename, 'a') as f:
        f.write(item)

def main():

    print("a")
if __name__ == '__main__':

    get_goods_list("p_5bed1130aa8a3_bTW7gCCa", r"C:\Users\putao-1\.0-wk\pozhu\买错房，错一生")
    #download_comments('1926157')
