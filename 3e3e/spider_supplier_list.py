from selenium import webdriver

import time,json,os
from selenium.webdriver.chrome.options import Options
import random

# headers = {
# 'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36'
# }
chrome_options = Options()
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')
chrome_options.add_argument('--headless')
browser = webdriver.Chrome(chrome_options=chrome_options)
#options = Options()
# # options = webdriver.ChromeOptions()
# options.add_argument('user-agent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36"')
#prefs = {"profile.managed_default_content_settings.images": 2}
#options.add_experimental_option('prefs', prefs)
#browser = webdriver.Chrome(options=options)

# 不加载图片
# prefs = {"profile.managed_default_content_settings.images": 2}
# options.add_experimental_option('prefs', prefs)
# browser = webdriver.Chrome()
# url = 'http://www.3e3e.cn/supplier/qjg/'
# browser = webdriver.Chrome(r"C:\Users\tianyu\AppData\Local\Google\Chrome\Application\chromedriver.exe")
# browser.get(url)
# 这个过于复杂，还是应该用先获取根节点，然后在根节点下逐个遍历，这样容易理解。

class Children3e:
    def spider(self,url):
        # 定义供应等级字典
        supply_grade_dic = {
            "s_20.gif":"5王者","s_19.gif":"4王者","s_18.gif":"3王者","s_17.gif":"2王者","s_16.gif":"1王者","s_15.gif":"5星耀",
            "s_14.gif":"4星耀","s_13.gif":"3星耀","s_12.gif":"2星耀","s_11.gif":"1星耀","s_10.gif":"5钻石","s_9.gif":"4钻石",
            "s_8.gif":"3钻石","s_7.gif":"2钻石","s_6.gif":"1钻石","s_5.gif":"5爱心","s_4.gif":"4爱心","s_3.gif":"3爱心",
            "s_2.gif":"2爱心","s_1.gif":"1爱心"
        }

        # browser = webdriver.Chrome(r"C:\Users\tianyu\AppData\Local\Google\Chrome\Application\chromedriver.exe")
        browser.get(url)
        total_shop_num = 0
        res = []
        index = 0
        while True:
            currs = browser.find_elements_by_css_selector('.certified-list .certified-title-box .certified-name')

            # 如果当前数里往后走是空的结束while循环，说明已经滑倒底部，提取不到其他数据了
            # currs在这里的作用除了提取连接以外判断结束循环外，还要作为循环遍历体，逐个提取其他字段，total_shop_name记录当前的店家总数量，每次都从当前数量往下走
            # 开始
            print('当前进度：%d'%total_shop_num)
            a = total_shop_num
            end_list = []
            for cur in currs[a:]:
                end = cur.get_attribute('href')
                end_list.append(end)
                total_shop_num+=1
            # if total_shop_num in [140,240,340,400,800,1200,1600]:
            #     time.sleep(10)

            links = browser.find_elements_by_css_selector('.certified-list .certified-title-box .certified-name')
            shop_names = browser.find_elements_by_css_selector('.certified-list .certified-title-box a')
            contacts = browser.find_elements_by_css_selector('.certified-list .link-man')
            telephones_one = browser.find_elements_by_xpath('//span[@class="link-man"]/../span[2]')    # 电话号码可能有两个用elements，用列表处理
            telephones_two = browser.find_elements_by_xpath('//span[@class="link-man"]/../span[3]')
            telephone_length = browser.find_elements_by_xpath('//span[@class="link-man"]/..')
            bussiness_scopes = browser.find_elements_by_xpath('//span[@class="title"]/../../p[3]')
            get_addrs = browser.find_elements_by_xpath('//span[@class="title"]/../../p[4]')
            nums = browser.find_elements_by_css_selector('.certified-status .pull-right .color-orange')
            golds = browser.find_elements_by_css_selector('.certified-status .pull-left')
            register_times = browser.find_elements_by_xpath('//p[contains(text(),"注册时间")]/span')
            supply_grades = browser.find_elements_by_xpath('//p[contains(text(),"供应等级")]/img')
            # print('这是个啥啊',register_times)
            # for tele in telephones_two:
                # print('记录一下',tele.text)
            for register_time in register_times:
                print(register_time.text)
            print('当前进度：%d'%total_shop_num)
            # for gold in golds:
            #     res = gold.get_attribute('textContent').split()
                # print('金牌商家：%s'%','.join(res))

            for i in range(a,total_shop_num):
                dic = {}
                link = links[i].get_attribute('href')
                shop_name = shop_names[i].get_attribute('title')
                contact = contacts[i].get_attribute('title')
                telephone_one = telephones_one[i].text
                if len(telephone_length[i].find_elements_by_css_selector('span'))>2:
                    telephone = [telephone_one,telephones_two[index].text]
                    index+=1
                else:
                    telephone = telephone_one
                register_time = register_times[i].text
                bussiness_scope = bussiness_scopes[i].text
                get_addr = get_addrs[i].text
                num = nums[i].get_attribute('textContent')
                info = golds[i].get_attribute('textContent').split()
                gold = ','.join(info)
                supply_grade = supply_grades[i].get_attribute('src')
                switch_supply_grade = supply_grade_dic[supply_grade.split('/')[-1]]

            #
                dic['link'] = link
                dic['shop_name']=shop_name
                dic['register_time'] = register_time+'天'
                dic['supply_grade'] = switch_supply_grade
                dic['gold'] = gold
                dic['contact'] = contact
                dic['telephone'] = telephone
                dic['bussiness_scope'] = bussiness_scope
                dic['get_addr'] = get_addr
                dic['num'] = num
                res.append(dic)

            # 终止
            if not end_list:
                break

            browser.execute_script('window.scrollTo(0,document.body.scrollHeight)')
            # browser.implicitly_wait(5)
            # time.sleep(random.randint(2,5))
            time.sleep(2)
        # browser.close()
        # browser.quit()
        return total_shop_num,res



def excute():
    # url = 'http://www.3e3e.cn/supplier/qjg/'
    dic = {
        # 0:'http://www.3e3e.cn/supplier/',
        1:'http://www.3e3e.cn/supplier/dhc/',
        2:'http://www.3e3e.cn/supplier/hxc/',
        3:'http://www.3e3e.cn/supplier/qjg/',
        4:'http://www.3e3e.cn/supplier/tzc/',
        5:'http://www.3e3e.cn/supplier/wltx/',
        6:'http://www.3e3e.cn/supplier/qt/'
    }

    filename_dic = {
        'dhc':'大和村',
        'hxc':'河西村',
        'qjg':'秦家港',
        'tzc':'童装城',
        'wltx':'温州童鞋',
        'qt':'其他'
    }

    count = 0
    # count = spider(dic[2])
    # for i in range(1,7):
    #     total_shop_num = spider(dic[i])
    #     count+=total_shop_num
    # print('商家数量',count)

    # browser.close()
    # browser.quit()

    classify = ['0-9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']

    for i in range(1,7):
        for suffix in classify:
            url = dic[i]+'?&sort=&capital={}&keyword='.format(suffix)
            print(url)
            addr = 'D:/data'+'/'+filename_dic[dic[i].split('/')[-2]]
            if not os.path.exists(addr):
                os.makedirs(addr)
            filename = suffix+'.json'
            path = addr+'/'+filename
            total,res = Child.spider(url)
            with open(path,'w',encoding='utf-8') as f:
                f.write(json.dumps(res,ensure_ascii=False))
            count+=total
        print("每个分类的数量",count)
    print("总数量",count)


if __name__ == '__main__':
    Child = Children3e()
    excute()
