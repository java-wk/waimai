from selenium import webdriver
from bs4 import BeautifulSoup
from selenium.webdriver.chrome.options import Options
from spider_goods_detail import GetDetail
import time,json,requests,os

chrome_options = Options()
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')
chrome_options.add_argument('--headless')
prefs = {"profile.managed_default_content_settings.images": 2}
chrome_options.add_experimental_option('prefs', prefs)
browser = webdriver.Chrome(options=chrome_options)


def spider_goods_list(url):
    browser.get(url)

    # 店家信息一次就能获取到，商品列表信息因为因为动态加载需要多次获取
    info_dic = {}
    # http://jtcb.3e3e.cn/supply.html
    firstPageLink = url.split('supply.html')[0]
    print("商家首页网址",firstPageLink)

    shop_name = browser.find_element_by_css_selector('.general-supplier span').get_attribute('title')
    print("店铺名称",shop_name)

    contact_number =browser.find_elements_by_css_selector('.merchant-phone .PhoneInput')
    telephone_list = []
    qqNumber = ''
    for telephone in contact_number:
        tele_number = telephone.get_attribute('value')
        if len(tele_number)>10:
            telephone_list.append(tele_number)
        else:
            qqNumber = tele_number
    print("手机号列表",telephone_list)
    print("qq号",qqNumber)

    merchant_address = browser.find_element_by_css_selector('.merchant-lite-info .merchant-address').text.split("厂址")[0]
    print("档口地址",merchant_address)

    QR_code = browser.find_element_by_css_selector('.header-two-code').get_attribute('src')
    print("二维码",QR_code)

    photo_certificates_url = firstPageLink+'photo.html'
    data = requests.get(photo_certificates_url).text
    soup = BeautifulSoup(data,'html.parser')
    photo_certificates = soup.select('.big-img-list li a')[0].get('href')
    print("商家证照",photo_certificates)

    info_dic['firstPageLink'] = firstPageLink
    info_dic['shop_name'] = shop_name
    info_dic['telephone_list'] = telephone_list
    info_dic['qqNumber'] = qqNumber
    info_dic['merchant_address'] = merchant_address
    info_dic['QR_code'] = QR_code
    info_dic['photo_certificates'] = photo_certificates


    total_goods_num = 0
    res = []
    while True:
        currs = browser.find_elements_by_css_selector('.main-list-item')


        # 开始
        print('当前进度：%d'%total_goods_num)
        a = total_goods_num
        end_list = []
        for cur in currs[a:]:
            ch = cur.find_element_by_css_selector('.product-btn a')
            end = ch.get_attribute('href')
            end_list.append(end)
            total_goods_num+=1


        for li in currs[a:]:
            detail_link = li.find_element_by_css_selector('.product-btn a').get_attribute('href')
            price = li.find_element_by_css_selector('.price').text
            distribution_num = li.find_element_by_css_selector('.already-distrib span').text
            title = li.find_element_by_css_selector('.product-btn a').get_attribute('title')
            pictrue = li.find_element_by_css_selector('.product-img-box a img').get_attribute('src')
            goods = GetDetail(detail_link).spider()

            # 在这里完成商品详情页面的爬取，方便存储在product中，用模块导入的方式来实现

            product = {
                'detail_link':detail_link,
                'price':price,
                'distribution_num':distribution_num,
                'title':title,
                'picture':pictrue,
                'goods':goods
            }

            res.append(product)
        # if total_goods_num==20:
        #     break
        # 终止条件
        if not end_list:
            break

        browser.execute_script('window.scrollTo(0,document.body.scrollHeight)')
        # browser.implicitly_wait(5)
        # time.sleep(random.randint(2,5))
        time.sleep(2)
    info_dic['goods_list'] = res


    return info_dic

def excute(url):
    info = spider_goods_list(url)
    path = 'D:/python/child_data'
    if not os.path.exists(path):
        os.makedirs(path)
    path = path+'/'+'goods.json'
    with open(path,'w',encoding='utf-8') as f:
        f.write(json.dumps(info,ensure_ascii=False))
    # print(json.dumps(info))

if __name__ == '__main__':
    print("请输入商家所有产品页面地址")
    url = input()
    # 例如 url = "http://yihao123.3e3e.cn/supply.html"
    excute(url)
