# encoding=utf-8
import codecs
# http.client.HTTPConnection.debuglevel=1
import json
import os
import time
import traceback
from random import randint

import requests
import requests as req

sess = req.session()


def download_page(url, ref=None):
    # headers = {'User-Agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36',
    #         'Referer': ref if ref is not None else 'https://pc.pozhu.com/detail/p_5c40255374cf6_jyaZrMUk/6'}

    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36',
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
            c = sess.get(url, headers=headers, timeout=10).content

    except:
        print(traceback.print_exc())
        return None

    dur = randint(1, 8)
    time.sleep(dur)
    return c


def get_cookies():
    # s = 'Hm_lvt_ea41f8e8649861379ed632abed12f208=1590374983; anonymous_user_key=dV9hbm9ueW1vdXNfNWVjYjMyYmQ5OGVjNF9sRWNBTlE1VXM0; dataUpJssdkCookie={"wxver":"","net":"","sid":""}; Hm_lpvt_ea41f8e8649861379ed632abed12f208=1590984076; app_id="appn7n2xNJL4210"; pc_user_key=0c96e6163bcb103e9de528e48bbd96c7; userInfo={"app_id":"appn7n2xNJL4210","user_id":"u_5c4a5b1292ac0_AhsCnwcDDt","wx_name":"宏宇","wx_nickname":"test","wx_avatar":"http://wechatavator-1252524126.file.myqcloud.com/appn7n2xNJL4210/image/compress/u_5c4a5b1292ac0_AhsCnwcDDt.png","wx_gender":1,"birth":null,"address":null,"job":null,"company":null,"wx_account":"","phone":"18810539359","pc_user_key":"0c96e6163bcb103e9de528e48bbd96c7"}'
    s = 'anonymous_user_key=dV9hbm9ueW1vdXNfNWVjYjMyYmQ5OGVjNF9sRWNBTlE1VXM0; Hm_lvt_ea41f8e8649861379ed632abed12f208=1594617769,1596358127; Hm_lpvt_ea41f8e8649861379ed632abed12f208=1596358127; dataUpJssdkCookie={"wxver":"","net":"","sid":""}; pc_user_key=e6652ae83f186a4cbbbe7866c60af139; app_id="appn7n2xNJL4210"; userInfo={"app_id":"appn7n2xNJL4210","user_id":"u_5c4a5b1292ac0_AhsCnwcDDt","wx_avatar":"http://wechatavator-1252524126.file.myqcloud.com/appn7n2xNJL4210/image/compress/u_5c4a5b1292ac0_AhsCnwcDDt.png","wx_gender":1,"birth":null,"address":null,"job":null,"company":null,"wx_account":"","phone":"18810539359","pc_user_key":"e6652ae83f186a4cbbbe7866c60af139"}'

    # s = s1.encode("utf-8")
    res = {}

    for ele in s.split(';'):
        ele = ele.strip()

        sl = ele.split('=')
        k = sl[0]

        v = '='.join(sl[1:])

        res[k] = v.encode("utf-8").decode('latin-1')

    return res


def get_post_data(url, post_data, ref=None):
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36',
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
    c = req.post(url, headers=headers, cookies=cookies, data=post_data)
    return c


#### save_folder_path 要保存的文件夹
#### product_id  示例 https://pc.pozhu.com/detail/p_5b3d756f6a32c_A6P6U2xR/6 中的 p_5b3d756f6a32c_A6P6U2xR


def get_goods_list(product_id, save_folder_path):
    last_id = ""
    prior_last_id = "initial"
    while last_id != prior_last_id:
        data_str = '{"page_size":20,"goods_id":"%s","last_id":"%s","goods_type":6,"resource_type":[1,2,3,4]}' % (
            product_id, last_id)
        post_data = data_str.encode('utf-8').decode('latin-1')
        url = "https://pc.pozhu.com/api/xe.goods.relation.get/1.0.0?app_id=appn7n2xNJL4210"
        refer = "https://pc.pozhu.com/detail/%s/6" % (product_id)
        c = get_post_data(url, post_data, ref=refer)
        print(save_folder_path)
        dur = randint(2, 3)
        time.sleep(dur)
        if c.status_code == 200:
            response_data = json.loads(c.text.encode('utf-8'))
            # print(response_data["data"]["goods_list"])
            goods_list = response_data["data"]["goods_list"]
            if len(goods_list) == 0:
                prior_last_id = last_id
            for ele in goods_list:
                # print("order: %s" % (goods_list.index(ele)))
                print(formatName(ele["title"]) + " -原标题@ " + ele["start_at"] + ele["title"])

                if goods_list.index(ele) + 1 == len(goods_list):
                    prior_last_id = last_id
                    last_id = ele["resource_id"]

                detail_interface_url = "https://pc.pozhu.com/api/xe.goods.detail.get/2.0.0?app_id=appn7n2xNJL4210"
                tmp_data_str = '{"goods_id":"%s","goods_type":2}' % (ele["resource_id"])
                tmp_post_data = tmp_data_str.encode('utf-8').decode('latin-1')
                tmp_refer = 'https://pc.pozhu.com' + ele["redirect_url"]
                dur = randint(1, 2)
                time.sleep(dur)
                tmp_c = get_post_data(detail_interface_url, tmp_post_data, tmp_refer)
                if tmp_c.status_code == 200:
                    process_detail_json(save_folder_path, tmp_c.text, tmp_refer)
                else:
                    save_item_to_file(os.path.join(save_folder_path, "failed_url.txt"), tmp_refer + "\n")


def formatName(s):
    s = s.replace('【第一百期】', '100 -') \
        .replace('【第二十期】', '20 -') \
        .replace('【第三十期】', '30 -') \
        .replace('【第四十期】', '40 -') \
        .replace('【第五十期】', '50 -') \
        .replace('【第六十期】', '60 -') \
        .replace('【第七十期】', '70 -') \
        .replace('【第八十期】', '80 -') \
        .replace('【第九十期】', '90 -') \
        .replace('【第十期】', '10 -').replace('第十期', '10'). \
        replace('【第十', '1') \
        .replace('【第', '').replace('期】', ' -').replace('十', '').replace('一百', '1')\
        .replace('一', '1').replace('二', '2').replace('三', '3').replace('四', '4').replace('五', '5')\
        .replace('六', '6').replace('七', '7').replace('八', '8').replace('九', '9').replace('零', '0').replace('】', '')
    return formatDot(s)


def formatDot(s):
    s = s.replace('?', '').replace('|', '').replace('/', '').replace('\\', '').replace(
        ':', '').replace('*', '').replace('"', '').replace('>', '').replace('<', '')

    return s


def process_detail_json(save_folder_path, json_str, detail_url):
    # print(json_str)
    detail_dict = json.loads(json_str)["data"]

    try:
        if detail_dict is not None:
            save_item_to_file(os.path.join(save_folder_path, formatName(detail_dict["title"]) + " -原标题@ " + formatDot(
                detail_dict["start_at"] + detail_dict["title"]) + "-unicode.json"),
                              json.dumps(detail_dict))
            save_music(os.path.join(save_folder_path, formatName(detail_dict["title"]) + "  -原标题@ " + formatDot(
                detail_dict["start_at"] + detail_dict["title"]) + ".mp3"),
                       detail_dict["audio_url"])
        else:
            save_item_to_file(os.path.join(save_folder_path, "failed_url.txt"), detail_url + "\n")
    except:
        print(traceback.print_exc())
        return None

    try:
        if detail_dict is not None:
            save_item_to_file(os.path.join(save_folder_path,
                                           formatName(detail_dict["title"]) + " -原标题@ " + formatDot(
                                               detail_dict["start_at"] + detail_dict["title"]) + ".-decode.htm"),
                              json.dumps(detail_dict, ensure_ascii=False))
    except:
        print(traceback.print_exc())
        return None


def save_music(filename, url):
    with codecs.open(filename, 'ab') as file:  # 保存到本地的文件名
        file.write(requests.get(url).content)
        file.flush()


def save_item_to_file(filename, item):
    with codecs.open(filename, 'a', encoding='utf-8') as f:
        f.write(item)


def main():
    print("a")


if __name__ == '__main__':
    # 专栏
    # get_goods_list("p_5b447964c8667_WOoTDqUg", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\乔妹撩盘【郑州篇】")
    # get_goods_list("p_5b442062ddea8_VP2PWVqg", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\米公子的地产财经观·第一季")
    # get_goods_list("p_5b445f6f16c3a_V2dpXfvd", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\拾叶的财经笔记")
    # get_goods_list("p_5d410005a357e_bdQoof3Y", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\被刚需撕裂的青岛楼市")
    # get_goods_list("p_5de0d62c6e43e_NlXkN9IT", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\天津买房20问")
    #
    # get_goods_list("p_5d0c4460f0d78_fPI3vYzG", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\王老师的百万千平攻略")
    # get_goods_list("p_5c078e04d7eb4_mexXIpev", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\重庆买房实用宝典")
    # get_goods_list("p_5db7fec1cdd60_gJeFwt6S", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\魔幻的西安楼市")
    # get_goods_list("p_5db7fab3783a4_lBZauPEe", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\南京买房必修课")
    # get_goods_list("p_5db65269b1370_iHpebu4Q", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\深圳房产投资密码")
    #
    # get_goods_list("p_5da16a468fae9_CX1EdUpd", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\园长说广州楼市")
    # get_goods_list("p_5d4a3ffe66d9c_v9pyms1H", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\武汉买房社")
    # get_goods_list("p_5c9b3f99add43_DMJRlAbe", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\1号陪你聊旅居")
    # get_goods_list("p_5bed1130aa8a3_bTW7gCCa", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\【买错房，错一生】")
    # get_goods_list("p_5ce5131025108_ODbmpIrH", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\软装设计，让家更有温度")
    #
    # get_goods_list("p_5c79dcc76621c_e3pSKrZ3", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\老A的杠杆术")
    # get_goods_list("p_5c47ce8723780_YMQnP1an", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\菌爷的财富实战课堂")
    # get_goods_list("p_5d6e1739c1194_bTOJPgC4", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\楼市先声第二季")
    # get_goods_list("p_5caf048db343e_PMfWE6tK", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\乔妹撩盘第二季")
    # get_goods_list("p_5c8a02dc23664_oCaxLi1N", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\大白楼市一线声音第二季")
    #
    # get_goods_list("p_5c63795ee95ae_IxTGP0an", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\投资三万问第二季")
    # get_goods_list("p_5c4ec27a48c19_yzhoYy4L", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\葫芦娃观地产第二季")
    # get_goods_list("p_5c40255374cf6_jyaZrMUk", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\米公子的地产财经观·第二季")
    # get_goods_list("p_5e4753abf0603_bCJtJOAS", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\菌爷的财富实战课堂 第二季")
    # get_goods_list("p_5e4a5dc64e65f_jrx4y5rH", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\葫芦娃观地产第三季")
    #
    # get_goods_list("p_5b442128d027d_FXXuGxUG", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\大白的楼市一线声音")
    # get_goods_list("p_5b441fe598e3b_pL6aJcq2", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\葫芦娃观地产")
    # get_goods_list("p_5b446df039898_LNYUN1xM", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\投资三万问")
    # get_goods_list("p_5ba3847766126_qTZQaWxQ", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\楼市先声")
    get_goods_list("p_5e4753abf0603_bCJtJOAS", r"D:\Users\putao-1\.0-wk\pozhu\专栏-破竹主编大课\菌爷的财富实战课堂 第二季新")
    #
    # # 专栏-精华知识点小课
    # get_goods_list("p_5b7bdf332681c_kIi7tbOH", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\职业买家房产投资实操攻略")
    # get_goods_list("p_5b3604de3cf8e_8teWsPhq", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\米公子看海外")
    # get_goods_list("p_5cb6d158c95cc_F4EfaZzc", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\买房是件专业的事-孟老师房产投资实战课")
    # get_goods_list("p_5b44158fc0d12_Njgvahm3", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\三万的金融思维课")
    # get_goods_list("p_5b2c6ebf23eec_fmKdYqBh", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\A先生投资方法论-零基础投资实战课")
    #
    # get_goods_list("p_5be3d44c43760_6vYlCTmO", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\【小白的第一堂投资课】")
    # get_goods_list("p_5b3d756f6a32c_A6P6U2xR", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\A先生·债务撬动财富")
    # get_goods_list("p_5b3dcccf5855b_CIDrvIeJ", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\A先生的概率课堂")
    # get_goods_list("p_5b44474248534_QkXWVLCk", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\抱朴·装修全书")
    # get_goods_list("p_5b4422f35e754_cIKw6mpy", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\小白买房词典")
    #
    # get_goods_list("p_5b44273d2e297_OCwlAcYU", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\大白读懂欧神第一季")
    # get_goods_list("p_5b44295431500_2MIPCzcS", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\大白读懂欧神第二季")
    # get_goods_list("p_5b62bf4738a76_ke4uwBnM", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\大白读欧神第三季")
    # get_goods_list("p_5b445c5e79b28_u5lGBYp1", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\小爱聊学区")
    # get_goods_list("p_5b44224e3ebc3_WK5g8HLR", r"D:\Users\putao-1\.0-wk\pozhu\专栏-精华知识点小课\2018魔都聪明置业法则")
