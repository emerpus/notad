import os, pystrich.ean13, qrcode, random, time

random_string_list = []
number = "0123456789"
letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"

# 显示系统菜单
def main_menu():
    print("""
        ****************************************
                    企业编码生成系统
        ****************************************
            1. 生成6位数字防伪编码
            2. 生成9位系列产品数字防伪编码
            3. 生成25位混合产品序列号
            4. 生成含数据分析功能的防伪编码
            5. 智能批量生成带数据分析功能的防伪编码
            6. 后续补加生成防伪码
            7. EAN-13条形码批量生成
            8. 二维码批量生层
            9. 企业粉丝防伪码抽奖
            0. 退出系统
        
        ========================================
        说明：使用数字键选择菜单
        ========================================
    """)

# 判断输入的字符串是否合法
# 主要用于判断菜单选择的输入，因此主要判断输入是否为数字
def input_validation(selection):
    if selection.isdigit():
        return True
    else:
        print("输入非法，请重新输入！！")
        return False

# 选择菜单1
def scode1():
    count = input("请输入需要生成防伪码的数量：")
    random_string_list.clear()
    for i in range(int(count)):
        single_random_char = ""
        for j in range(6):
            single_random_char += random.choice(number)
        random_string_list.append(single_random_char)
    print("已为您生成" + count + "个防伪码，具体如下：")
    print(random_string_list)

# 选择菜单2
def scode2():
    series_code = input("请输入系列产品的数字起始号（3位）：")
    series_count = input("请输入产品系列的数量：")
    count = input("请输入为每个产品系列生成的防伪码数量：")
    random_string_list.clear()
    for i in range(int(series_count)):
        for j in range(int(count)):
            single_random_string = ""
            for m in range(6):
                single_random_string += random.choice(number)
            single_random_string = series_code + single_random_string
            random_string_list.append(single_random_string)
        series_code = str(int(series_code) + 1)
    print("已为您生成" + count + "个防伪码，具体如下：")
    print(random_string_list)

# 选择菜单3
def scode3():
    count = input("请输入要生成的25位混合产品序列号数量：")
    random_string_list.clear()
    for i in range(int(count)):
        single_random_string = ""
        for j in range(25):
            single_random_string += random.choice(letter)
        string_with_dash = single_random_string[0:5] + "-" + single_random_string[5:10] + "-" + single_random_string[15:20] + "-" + single_random_string[20:25]
        random_string_list.append(string_with_dash)
    print("已为您生成" + count + "个防伪码，具体如下：")
    print(random_string_list)

# 选择菜单4
def scode4():
    analysis_type = input("请输入数据分析编号（3位字母）：")
    count = input("请输入要生成的带数据分析功能的防伪码数量：")
    random_string_list.clear()
    for i in range(int(count)):
        area = analysis_type[0].upper()
        color = analysis_type[1].upper()
        version = analysis_type[2].upper()
        random_position = sorted(random.sample(number, 3))
        letter_one = ""
        for j in range(9):
            letter_one += random.choice(number)
        single_random_string = letter_one[0:int(random_position[0])] + area + letter_one[int(random_position[0]):int(random_position[1])] + color + letter_one[int(random_position[1]):int(random_position[2])] + version + letter_one[int(random_position[2]):9]
        random_string_list.append(single_random_string)
    print("已为您生成" + count + "个防伪码，具体如下：")
    print(random_string_list)

def scode5():
    print("此功能与选项4相似，但目前还未实现")

def scode6():
    print("此功能与选项4相似，但目前还未实现")

# EAN-13是European Article Number（欧洲物品编码），总共13位
def scode7():
    country_id = input("请输入EAN13的国家代码（3位）：")
    company_id = input("请输入EAN13的企业代码（4位）：")
    count = input("请输入要生成的条形码数量：")
    
    if not os.path.exists("EAN13"):
        os.mkdir("EAN13")
    for i in range(int(count)):
        random_string = ""
        for j in range(5):
            random_string += random.choice(number)
        ean13_code = country_id + company_id + random_string
        even_sum = int(ean13_code[1]) + int(ean13_code[3]) + int(ean13_code[5]) + int(ean13_code[7]) + int(ean13_code[9]) + int(ean13_code[11])
        odd_sum = int(ean13_code[0]) + int(ean13_code[2]) + int(ean13_code[4]) + int(ean13_code[6]) + int(ean13_code[8]) + int(ean13_code[10])
    check_bit = int(10 - ((even_sum * 3 + odd_sum) % 10) % 10)
    ean13_code = ean13_code + str(check_bit)
    encoder = pystrich.ean13.EAN13Encoder(ean13_code)
    encoder.save("EAN13/" + ean13_code + ".png")
    print("已为您生成条形码");

# QR二维码
def scode8():
    count = input("请输入要生成的12位数字二维码数量：")

    if not os.path.exists("qrcode"):
        os.mkdir("qrcode")
    for i in range(int(count)):
        random_string = ""
        for j in range(12):
            random_string += random.choice(number)
        encoder = qrcode.make(random_string)
        encoder.save("qrcode/" + random_string + ".png")
    print("已为您生成二维码");

if __name__ == "__main__":
    while (True):
        main_menu()

        selection = input("请输入您要操作的菜单选项：")
        if selection == "1":
            scode1()
        elif selection == "2":
            scode2()
        elif selection == "3":
            scode3()
        elif selection == "4":
            scode4()
        elif selection == "7":
            scode7()
        elif selection == "8":
            scode8()
        elif selection == "0":
            break
            
        continue_or_not = input("是否继续？（y或n）：")
        if continue_or_not == "y":
            continue
        else:
            break
    print("正在退出系统...")

