package cn.lsh.demo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 *牌类
 * 4种花色
 * 13种牌面
 * 2张鬼
 *  */
public class PokerClass {
    //    花色
    private String[] Color = {"♥", "♣", "♦", "♠"};
    //    牌面
    private String[] Poker = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    //    鬼
    private String[] Ghost = {"小鬼", "大鬼"};


    //    生成一副牌的方法
    public ArrayList<String> generateP() {
        ArrayList<String> poker = new ArrayList<>();
        for (int i = 0; i < Color.length; i++) {
            for (int j = 0; j < Poker.length; j++) {
                poker.add(Color[i] + Poker[j]);
            }
        }
//        添加大小鬼
        poker.add(Ghost[0]);
        poker.add(Ghost[1]);
        System.out.println("牌已生成:");
        System.out.println(poker);
        System.out.println("==================================");
//        洗牌并抽取15张牌
        Collections.shuffle(poker);
        System.out.println("牌已准备完成");
        System.out.println("==================================");
        ArrayList<String> p = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            p.add(poker.get(i));
        }
        System.out.println(p);
        System.out.println("请在上面的牌中记住一张牌:");
        System.out.println("==================================");
        return p;
    }

    //发牌方法
    public ArrayList<String> distrbution(ArrayList<String> arrayList) {

        //三副(每副5张)牌
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        ArrayList<String> a3 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 3 == 0) {
                a1.add(arrayList.get(i));
            } else if (i % 2 == 1) {
                a2.add(arrayList.get(i));
            } else {
                a3.add(arrayList.get(i));
            }
        }
        ArrayList<String> s = new ArrayList<>();
        s.addAll(a1);
        s.addAll(a2);
        s.addAll(a3);
        return s;
    }

    //    重复洗牌
    public ArrayList<String> repeat(ArrayList<String> array) {
        ArrayList<String> b1 = new ArrayList<>();
        ArrayList<String> b2 = new ArrayList<>();
        ArrayList<String> b3 = new ArrayList<>();

        for (int i = 0; i <15 ; i++) {
            if(i<5){
                b1.add(array.get(i));
            }else if(i>=5&&i<10){
                b2.add(array.get(i));
            }else {
                b3.add(array.get(i));
            }
        }
        System.out.println("1:" + b1);
        System.out.println("2:" + b2);
        System.out.println("3:" + b3);
        System.out.println("==================================");
        System.out.println();
        System.out.println("你记住的牌在那一副牌中(请输入1,2或者3):");
        System.out.println("==================================");
        Scanner sc = new Scanner(System.in);
        while (true) {
            int f = sc.nextInt();
            if (f == 1) {
                b2.addAll(b1);
                b2.addAll(b3);
                return b2;
            } else if (f == 2) {
                b1.addAll(b2);
                b1.addAll(b3);
                return b1;
            } else if (f == 3) {
                b1.addAll(b3);
                b1.addAll(b2);
                return b1;
            } else {
                System.out.println("==================================");
                System.out.println("输入错误!!! 请重新输入:");
                continue;
            }
        }
    }

    //显示三副牌
//    public void show() {
//
//        System.out.println("1:" + a1);
//        System.out.println("2:" + a2);
//        System.out.println("3:" + a3);
//    }


    //最终结果
    public void result() {
        ArrayList<String> s0=new ArrayList<>();
        ArrayList<String> s1=new ArrayList<>();
        ArrayList<String> s2=new ArrayList<>();
        ArrayList<String> s3=new ArrayList<>();
        ArrayList<String> s4=new ArrayList<>();
        ArrayList<String> s5=new ArrayList<>();
        ArrayList<String> s6=new ArrayList<>();
    s0=generateP();
    s1=distrbution(s0);
    s2=repeat(s1);
    s3=distrbution(s2);
    s4=repeat(s3);
    s5=distrbution(s4);
    s6=repeat(s5);
        System.out.println("==================================");
        System.out.println("你记住的牌是:"+s6.get(7));
    }


}
