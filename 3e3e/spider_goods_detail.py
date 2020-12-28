from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import json,re

chrome_options = Options()
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')
chrome_options.add_argument('--headless')
prefs = {"profile.managed_default_content_settings.images": 2}
chrome_options.add_experimental_option('prefs', prefs)
browser = webdriver.Chrome(options=chrome_options)
# options = Options()
# prefs = {"profile.managed_default_content_settings.images": 2}
# options.add_experimental_option('prefs', prefs)
# browser = webdriver.Chrome(options=options)

class GetDetail:
    def __init__(self,url):
        self.url = url
    def spider(self):
        goods_dic = {}
        browser.get(self.url)
        title = browser.find_elements_by_css_selector('.product-details span')[0].text
        print(title)
        print("详情页地址",self.url)

        # 详情描述图片列表
        detail_img_list = []
        detail_img_target = browser.find_elements_by_css_selector('.product-details-content img')
        for img in detail_img_target:
            detail_img_list.append(img.get_attribute('src'))
        print("详情描述",detail_img_list)

        # 规格信息
        raw_skulist = re.findall("JSON.parse(.*?)}'",browser.page_source)[0]+"}"
        skulist = raw_skulist.split("('")[1]
        skulist_json = json.loads(skulist)
        print("规格信息",skulist_json)

        # 收藏数
        str_collect_num = browser.find_element_by_css_selector('.text-collected-current').text
        # collect_num = int(''.join(re.findall(r'\d',str_collect_num)))
        print("收藏数",str_collect_num)

        # 分销数
        distribution_num = browser.find_element_by_css_selector('.distribution-info .color-span').text
        print("分销数",distribution_num)

        # 商品详情
        goods_detail_target = browser.find_elements_by_css_selector('.details-attribute-item')
        goods_detail_list = []
        for goods in goods_detail_target:
            goods_detail_list.append(goods.get_attribute('title'))
        print("商品详情",goods_detail_list)

        # 备注
        #  备注可能有两种情况
        try:
            remarks = browser.find_element_by_css_selector('.show-enjoy-tit').get_attribute('title')
        except Exception:
            remarks = ''
        if not remarks:
            remarks = browser.find_element_by_css_selector('h6').text

        goods_dic['title'] = title
        goods_dic['detail_img_list'] = detail_img_list
        goods_dic['skulist'] = skulist_json
        goods_dic['collect_num'] = str_collect_num
        goods_dic['distribution_num'] = distribution_num
        goods_dic['goods_detail_list'] = goods_detail_list
        goods_dic['remarks'] = remarks


        return goods_dic


# url = 'http://www.3e3e.cn/product/qqoommg.html'
#
# goods = GetDetail(url).spider()
# print(json.dumps(goods))

