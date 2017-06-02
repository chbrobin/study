package pers.chbrobin.study.jdk;

import pers.chbrobin.study.util.SizeOf;

import java.util.Objects;

/**
 Created by Administrator on 2017/6/2 0002.
 java��û���ֳɵ�sizeof��ʵ�֣�ԭ����Ҫ��java�еĻ����������͵Ĵ�С���ǹ̶��ģ����Կ���ȥû�б�Ҫ��sizeof����ؼ���
 int     32bit  -2,147,483,648��2,147,483,647 Ĭ��Ϊ0
 short   16bit -32,768��32,767  Ĭ��Ϊ0
 long    64bit  -9,223,372,036,854,775,808L��9,223,372,036,854,775,807L  Ĭ��Ϊ0L
 byte    8bit -128��127  Ĭ��Ϊ0
 char    16bit
 float   32bit Լ+��3.40282347E+38F��6~7����Ч��ʮ������λ�� Ĭ��Ϊ0.0F
 double  64bit Լ+-1.79769313486231570E+308��15����Ч��λ��  Ĭ��Ϊ0.0D
 boolean 1bit��This data type represents one bit of information, but its "size" isn't something that's precisely defined.��ref��

 8 boolean byte
 16 char short
 32 int float
 64 long double
 */
public class SizeOfTest {
    public static void main(String[] args) {
        System.out.println("Integer: " + Integer.SIZE/8);           // 4
        System.out.println("Short: " + Short.SIZE/8);               // 2
        System.out.println("Long: " + Long.SIZE/8);                 // 8
        System.out.println("Byte: " + Byte.SIZE/8);                 // 1
        System.out.println("Character: " + Character.SIZE/8);       // 2
        System.out.println("Float: " + Float.SIZE/8);               // 4
        System.out.println("Double: " + Double.SIZE/8);             // 8
//      System.out.println("Boolean: " + Boolean);                      // bool true/false

        String numberCharacter="1";
        System.out.println(numberCharacter.getBytes().length); // 1
        String englishCharacter="c";
        System.out.println(englishCharacter.getBytes().length); // 1
        String chineseCharacter="��";
        System.out.println(chineseCharacter.getBytes().length); // 2

        System.out.println(SizeOf.sizeOf(chineseCharacter));
    }
}
