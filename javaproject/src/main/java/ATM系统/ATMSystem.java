package ATM系统;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    /*
    系统准备内容分析：
        1、每个用户的账户信息都是一个对象，需要提供账户类
        2、需要准备一个容器，用于存储系统全部账户对象信息
        3、首页只需要包含：登录和注册两个功能
    实现步骤：
        1、定义账户类，用于后期创建账户对象封装用户信息
        2、账户类中的信息至少需要包含（卡号、姓名、密码、余额、取现额度）
        3、需要准备一个ArrayList的集合，用于存储系统用户的账户对象
        4、需要展示欢迎页包含两个功能：开户功能、登录账户
     */
    public static void main(String[] args) {
        //1、定义账户类
        //2、定义一个集合容器，负责以后存储全部的账户对象进行相关的业务操作
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        //3、展示系统的首页
        while (true) {
            System.out.println("=================ATM系统===================");
            System.out.println("1、账户登录");
            System.out.println("2、账户开户");

            System.out.println("请您选择操作：");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    //用户登录操作
                    /*
                    分析：
                        1、登录功能应该定义成一个方法，并传入账户集合
                        2、让用户输入卡号，根据卡号去账户集合中查询账户对象
                        3、如果没有找到账户对象，说明登录卡号不存在，提示继续输入卡号
                        4、如果找到了账户对象，书名卡号存在，继续输入密码
                        5、如果密码不正确，提示继续输入密码
                        6、如果密码也正确，登录成功
                     */
                    login(accounts, sc);
                    break;
                case 2:
                    //用户账户开户
                    /*
                    用户开户功能实现：
                    分析：
                        1、开户功能其实就是网系统的集合容器中存入一个新的账户对象的信息
                     开户功能实现步骤：
                        1、开户应该定义成一个方法，并传入账户集合：
                        2、创建一个Account账户类的对象用于封装账户信息（姓名、密码、卡号）
                        3、键盘录入姓名、密码、确认密码（需保证两次密码一致）
                        4、生成账户卡号，卡号必须由系统自动生成8位数字（必须保证卡号的唯一）
                        5、把Account账户对象存入到集合accounts中去
                     */
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("您输入的操作命令不存在~~");
            }
        }
    }

    /**
     * 登录功能
     *
     * @param accounts 全部账户对象的集合
     * @param sc       扫描器
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("========================系统登录操作======================");
        //1、判断账户集合中是否存在账户，如果不存在账户，登录功能不能进行。
        if (accounts.size() == 0) {
            System.out.println("对不起，当前系统中，无任何账户，请先开户，再来登录~~~");
            return;//结束方法的执行
        }

        while (true) {
            //2、正式进入登录操作
            System.out.println("请您输入登录卡号：");
            String cardId = sc.next();
            //3、判断卡号是否存在，根据卡号去账户集合中查询账户对象
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc != null) {
                while (true) {
                    //卡号存在的
                    //4、让用户输入密码，认证密码
                    System.out.println("请您输入登录密码：");
                    String passWord = sc.next();
                    //判断当前账户对象的密码是否与用户输入的密码一致
                    if (acc.getPassWord().equals(passWord)) {
                        //登录成功了
                        System.out.println("恭喜您，" + acc.getUserName() + "先生/女士进入系统，您的卡号是：" + acc.getCardId());
                        /*
                        用户操作也设计、查询账户、退出账户功能分析
                            1、用户登录成功后，需要进入用户操作页
                            2、插叙金牛是直接展示当前登录成功的账户对象的信息
                            3、退出账户是需要回到首页的
                         */
                        //展示登录后的操作页。
                        showUserCommand(sc,acc,accounts);
                        return;
                    } else {
                        System.out.println("对不起，您输入的密码有误~~~");
                    }
                }
            } else {
                System.out.println("对不起，系统中不存在该账户卡号~~~");
            }
        }
    }

    /**
     * 展示登录后的操作页
     */
    private static void showUserCommand(Scanner sc,Account acc,ArrayList<Account> accounts) {
        while (true) {
            System.out.println("=================用户操作页==================");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销");
            System.out.println("请选择");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //查询账户
                    showAccount(acc);
                    break;
                case 2:
                    //存款
                    /*
                    存款分析
                        1、存款就是拿到当前账户对象
                        2、然后让用户输入存款的金额
                        3、调用账户对象的setMoney方法将账户余额修改成存钱后的余额
                        4、存钱后需要查询一下账户信息，确认是否存钱成功了
                     */
                    depositMoney(acc,sc);
                    break;
                case 3:
                    //取款
                    /*
                    取款分析：
                        1、取款需要先判断账户是否有钱
                        2、有钱则拿到自己账户对象
                        3、然后让用户输入取款金额
                        4、判断取款金额是否超过了当初限额，以及余额是否足够
                        5、满足要求则调用账户对象的setMoney方法完成金额的修改
                     */
                    drawMoney(acc,sc);
                    break;
                case 4:
                    //转账
                    /*
                     分析：
                        1、转账功能需要判断系统中是否有两个账户对象及以上
                        2、同时还要判断自己账户是否有钱
                        3、接下来需要输入对方卡号，判断对方账户上会否存在
                        4、对方账户存在还需要认证对方户主的姓氏
                        5、满足要求则可以把自己账户对象的金额修改到对方账户对象中去
                     */
                    transferMoney(sc,acc,accounts);
                    break;
                case 5:
                    //修改密码
                    /*
                    分析：
                        1、修改密码就是把当前对象的密码属性使用set方法进行更新
                        2、销户是从集合对象中删除当前对象，并返回首页
                     */
                    updatePassWord(sc,acc);
                    return;
                case 6:
                    //退出
                    System.out.println("退出成功，欢迎下次光临");
                    return;//跳出当前方法的执行
                case 7:
                    //注销账户
                    /*
                    从当前账户集合中，删除当前账户对象，销户就完成了
                     */
                   if(deleteAccount(acc,sc,accounts)){
                       //销户成功了，回到首页
                       return;
                   }else {
                       //没有销户成功，还是在操作页面
                       break;
                   }

                default:
                    System.out.println("您输入的命令有误");
            }
        }
    }

    /**
     * 销户功能
     * @param acc
     * @param sc
     * @param accounts
     */
    private static boolean deleteAccount(Account acc, Scanner sc, ArrayList<Account> accounts) {
        System.out.println("===============用户销户===============");
        System.out.println("您真的要销户？y/n");
        String rs = sc.next();
        switch (rs){
            case "y":
                //真正的销户
                if (acc.getMoney() > 0){
                    System.out.println("您账户中还有钱没有取完，不允许销户");
                }else {
                    accounts.remove(acc);
                    System.out.println("您的账户销户完成");
                    return true;
                }
                break;
            default:
                System.out.println("好的，当前账户继续保留");
        }
        return false;
    }

    /**
     * 修改密码
     * @param sc  扫描器
     * @param acc 当前登录成功的账户对象
     */
    private static void updatePassWord(Scanner sc, Account acc) {
        System.out.println("===============用户密码修改===============");
        while (true) {
            System.out.println("请您输入当前密码：");
            String passWord = sc.next();
            //1、判断这个密码是否正确
            if (acc.getPassWord().equals(passWord)){
                while (true) {
                    //密码正确
                    //2、输入新密码
                    System.out.println("请您输入新密码：");
                    String newPassWord = sc.next();

                    System.out.println("请您确认新密码：");
                    String okPassWord = sc.next();

                    if (newPassWord.equals(okPassWord)){
                        //两次密码一致，可以修改了
                        acc.setPassWord(newPassWord);
                        System.out.println("恭喜您，您密码修改成功了");
                        return;
                    }else {
                        System.out.println("您输入的两次密码不一致");
                    }
                }
            }else {
                System.out.println("您输入的密码不正确");
            }
        }
    }

    /**
     * 转账功能
     * @param sc 扫描器
     * @param acc 自己的账户对象
     * @param accounts 全部账户的集合
     */
    private static void transferMoney(Scanner sc, Account acc,ArrayList<Account> accounts) {
        System.out.println("===============用户转账操作===============");
        //1、判断是否足够两个账户
        if(accounts.size() < 2){
            System.out.println("当前系统中，不足两个张数，不能进行转账，请去开户");
            return;
        }

        //2、判断自己的账户是否有钱
        if (acc.getMoney() == 0){
            System.out.println("对不起，您自己都没有钱，就别转了");
            return;
        }

        while (true) {
            //3、真正开始转账
            System.out.println("请您输入对方的卡号：");
            String cardId = sc.next();

            //这个卡号不能是自己的卡号
            if (cardId.equals(acc.getCardId())){
                System.out.println("对不起，您不可以给自己转账");
                continue;//结束当次执行，死循环进入下次执行
            }
            //判断这个卡号是存在的：根据这个卡号去查询对方账户对象
            Account account = getAccountByCardId(cardId, accounts);
            if (account == null){
                System.out.println("对不起，您输入对方的这个账号不存在");
            }else {
                //这个账户对象存在，继续认证他的姓氏
                String userName = account.getUserName();
                String tip = "*" + userName.substring(1);
                System.out.println("请您输入["+ tip +"]的姓氏");
                String preName = sc.next();

                //认证姓氏是否输入正确。
                if(userName.startsWith(preName)){
                    while (true) {
                        //认证通过，真正开始转账
                        System.out.println("请您输入转账金额：");
                        double money = sc.nextDouble();
                        //判断余额是否足够
                        if (money > acc.getMoney()){
                            System.out.println("对不起，您月不足，您最多可以转账：" + acc.getMoney());
                        }else {
                            //余额足够，可以转了
                            acc.setMoney(acc.getMoney() - money);
                            account.setMoney(account.getMoney() + money);
                            System.out.println("转账成功！您的账户还剩余：" + acc.getMoney());
                            return;//退出方法
                        }
                    }
                }else {
                    System.out.println("对不起您输入的信息有误");

                }
            }
        }

    }

    /**
     * 取钱功能
     * @param acc 当前账户对象
     * @param sc  扫描器
     */
    private static void drawMoney(Account acc, Scanner sc) {
        System.out.println("===============用户取钱操作===============");
        //1、判断是否足够100元
        if (acc.getMoney() < 100){
            System.out.println("对不起，当前账户中不够100元，不能取钱");
            return;
        }

        while (true) {
            //2、提示用户输入取款金额
            System.out.println("请您输入取款金额：");
            double money = sc.nextDouble();

            //3、判断这个金额是否满足要求
            if (money > acc.getQuotaMoney()){
                System.out.println("对不起，您当前取款金额超过每次限额，每次最多可以取" + acc.getQuotaMoney());
            }else{
                //没有超过当次限额
                //4、判断是否超过了当湖的总余额
                if (money > acc.getMoney()){
                    System.out.println("余额不足，您账户目前总余额是：" + acc.getMoney());
                }else {
                    //可以取钱了
                    System.out.println("恭喜您，取钱" + money + "元，成功！");
                    //更新余额
                    acc.setMoney(acc.getMoney() - money);
                    //取钱结束了
                    showAccount(acc);
                    return;
                }

            }
        }

    }

    /**
     * 存钱
     * @param acc 当前账户对象
     * @param sc 扫描器
     */
    private static void depositMoney(Account acc, Scanner sc) {
        System.out.println("===============用户存钱操作===============");
        System.out.println("请您输入存款金额：");
        double money  = sc.nextDouble();

        //更新账户余额：原来的钱 + 新存入的钱
        acc.setMoney(acc.getMoney() + money);
        System.out.println("恭喜您，存钱成功，当前账户信息如下：");
        showAccount(acc);

    }

    private static void showAccount(Account acc) {
        System.out.println("===============当前账户信息如下===============");
        System.out.println("卡号：" + acc.getCardId());
        System.out.println("户主：" + acc.getUserName());
        System.out.println("余额：" + acc.getMoney());
        System.out.println("限额：" + acc.getQuotaMoney());

    }

    /**
     * 用户开户功能的实现
     *
     * @param accounts 接收的账户集合
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("===============系统开户操作===============");
        //1、创建一个账户对象，用于后期封装账户信息
        Account account = new Account();

        //2、录入当前这个账户的信息，注入到账户对象中去
        System.out.println("请您输入账户用户名：");
        String uerName = sc.next();
        account.setUserName(uerName);

        while (true) {
            System.out.println("请您输入账户密码：");
            String passWord = sc.next();
            System.out.println("请您输入确认密码：");
            String okPassWord = sc.next();
            if (okPassWord.equals(passWord)) {
                //密码认证通过，可以注入给账户对象
                account.setPassWord(okPassWord);
                break;//密码已经录入成功了，死循环没必要继续了
            } else {
                System.out.println("对不起，您输入的两次密码不一致，请重新确认~~");
            }
        }

        System.out.println("请您输入账户当次限额：");
        double quotaMoney = sc.nextDouble();
        account.setQuotaMoney(quotaMoney);

        //为账户随机一个8位且与其他账户的卡号不重复的号码(独立功能，独立成方法）
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);

        //3、把账户对象添加到账户集合中去
        accounts.add(account);
        System.out.println("恭喜您，" + uerName + "先生/女士,您开户成功，您的卡号是： " + cardId + "请您妥善保管");


    }

    /**
     * 为账户生成8位与其他账户卡号不同的号码
     *
     * @return
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        //1、先生成8位数字
        while (true) {
            String cardId = "";

            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            //2、判断这个8位的卡号是否与其他账户的卡号重复了
            //根据这个卡号去查询账户的对象
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null) {
                //说明cardId 此时没有重复，这个卡号是一个新卡号，可以使用这个卡号作为新注册的卡号了
                return cardId;
            }
        }
    }

    /**
     * 根据卡号查询出一个账号对象出来
     *
     * @param cardId   卡号
     * @param accounts 全部账户的集合
     * @return 账户对象|null
     */
    private static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;//查无此账号
    }
}
