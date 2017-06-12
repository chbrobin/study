//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pers.chbrobin.study.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.Map;

public class SizeOf {
    private static OutputStream out;
    private static Instrumentation inst;
    private static long MIN_CLASS_SIZE_TO_LOG;
    private static boolean SKIP_STATIC_FIELD;
    private static boolean SKIP_FINAL_FIELD;
    private static boolean SKIP_FLYWEIGHT_FIELD;
    private static boolean debug;
    private static String[] unit;

    public SizeOf() {
    }

    public static void premain(String var0, Instrumentation var1) {
        inst = var1;
        System.out.println("JAVAGENT: call premain instrumentation for class SizeOf");
    }

    public static long sizeOf(Object var0) {
        if(inst == null) {
            throw new IllegalStateException("Instrumentation is null");
        } else {
            return SKIP_FLYWEIGHT_FIELD && isSharedFlyweight(var0)?0L:inst.getObjectSize(var0);
        }
    }

    public static String humanReadable(long var0) {
        double var3 = (double)var0;

        int var2;
        for(var2 = 0; var2 < 3 && var3 >= 1024.0D; ++var2) {
            var3 /= 1024.0D;
        }

        return var3 + unit[var2];
    }

    public static long deepSizeOf(Object var0) {
        IdentityHashMap var1 = new IdentityHashMap();
        return deepSizeOf(var0, var1, 0);
    }

    /** @deprecated */
    public static long iterativeSizeOf(Object var0) throws IllegalArgumentException, IllegalAccessException, IOException {
        return deepSizeOf(var0);
    }

    private static String indent(int var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = 0; var2 < var0; ++var2) {
            var1.append("  ");
        }

        return var1.toString();
    }

    private static long deepSizeOf(Object var0, Map<Object, Object> var1, int var2) {
        if(var0 == null) {
            if(debug) {
                print("null\n");
            }

            return 0L;
        } else {
            long var3 = 0L;
            if(var1.containsKey(var0)) {
                if(debug) {
                    print("\n%s{ yet computed }\n", new Object[]{indent(var2)});
                }

                return 0L;
            } else {
                if(debug) {
                    print("\n%s{ %s\n", new Object[]{indent(var2), var0.getClass().getName()});
                }

                var1.put(var0, (Object)null);
                var3 = sizeOf(var0);
                int var7;
                int var8;
                if(var0 instanceof Object[]) {
                    int var5 = 0;
                    Object[] var6 = (Object[])((Object[])var0);
                    var7 = var6.length;

                    for(var8 = 0; var8 < var7; ++var8) {
                        Object var9 = var6[var8];
                        if(debug) {
                            print("%s [%d] = ", new Object[]{indent(var2), Integer.valueOf(var5++)});
                        }

                        var3 += deepSizeOf(var9, var1, var2 + 1);
                    }
                } else {
                    Field[] var14 = var0.getClass().getDeclaredFields();
                    Field[] var15 = var14;
                    var7 = var14.length;

                    for(var8 = 0; var8 < var7; ++var8) {
                        Field var16 = var15[var8];
                        var16.setAccessible(true);

                        Object var10;
                        try {
                            var10 = var16.get(var0);
                        } catch (IllegalArgumentException var12) {
                            throw new RuntimeException(var12);
                        } catch (IllegalAccessException var13) {
                            throw new RuntimeException(var13);
                        }

                        if(isComputable(var16)) {
                            if(debug) {
                                print("%s %s = ", new Object[]{indent(var2), var16.getName()});
                            }

                            var3 += deepSizeOf(var10, var1, var2 + 1);
                        } else if(debug) {
                            print("%s %s = %s\n", new Object[]{indent(var2), var16.getName(), var10.toString()});
                        }
                    }
                }

                if(debug) {
                    print("%s} size = %s\n", new Object[]{indent(var2), humanReadable(var3)});
                }

                if(MIN_CLASS_SIZE_TO_LOG > 0L && var3 >= MIN_CLASS_SIZE_TO_LOG) {
                    print("Found big object: %s%s@%s size: %s\n", new Object[]{indent(var2), var0.getClass().getName(), Integer.valueOf(System.identityHashCode(var0)), humanReadable(var3)});
                }

                return var3;
            }
        }
    }

    private static boolean isAPrimitiveType(Class var0) {
        return var0 == Boolean.TYPE?true:(var0 == Character.TYPE?true:(var0 == Byte.TYPE?true:(var0 == Short.TYPE?true:(var0 == Integer.TYPE?true:(var0 == Long.TYPE?true:(var0 == Float.TYPE?true:(var0 == Double.TYPE?true:var0 == Void.TYPE)))))));
    }

    private static boolean isComputable(Field var0) {
        int var1 = var0.getModifiers();
        return isAPrimitiveType(var0.getType())?false:(SKIP_STATIC_FIELD && Modifier.isStatic(var1)?false:!SKIP_FINAL_FIELD || !Modifier.isFinal(var1));
    }

    private static boolean isSharedFlyweight(Object var0) {
        if(var0 instanceof Comparable) {
            if(var0 instanceof Enum) {
                return true;
            }

            if(var0 instanceof String) {
                return var0 == ((String)var0).intern();
            }

            if(var0 instanceof Boolean) {
                return var0 == Boolean.TRUE || var0 == Boolean.FALSE;
            }

            if(var0 instanceof Integer) {
                return var0 == Integer.valueOf(((Integer)var0).intValue());
            }

            if(var0 instanceof Short) {
                return var0 == Short.valueOf(((Short)var0).shortValue());
            }

            if(var0 instanceof Byte) {
                return var0 == Byte.valueOf(((Byte)var0).byteValue());
            }

            if(var0 instanceof Long) {
                return var0 == Long.valueOf(((Long)var0).longValue());
            }

            if(var0 instanceof Character) {
                return var0 == Character.valueOf(((Character)var0).charValue());
            }
        }

        return false;
    }

    public static void setMinSizeToLog(long var0) {
        MIN_CLASS_SIZE_TO_LOG = var0;
    }

    public static void skipFinalField(boolean var0) {
        SKIP_FINAL_FIELD = var0;
    }

    public static void skipStaticField(boolean var0) {
        SKIP_STATIC_FIELD = var0;
    }

    public static void skipFlyweightObject(boolean var0) {
        SKIP_FLYWEIGHT_FIELD = var0;
    }

    private static void print(String var0) {
        try {
            out.write(var0.getBytes());
        } catch (IOException var2) {
            throw new RuntimeException(var2);
        }
    }

    private static void print(String var0, Object... var1) {
        try {
            out.write(String.format(var0, var1).getBytes());
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static void setLogOutputStream(OutputStream var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("Can\'t use a null OutputStream");
        } else {
            out = var0;
        }
    }

    public static void turnOnDebug() {
        debug = true;
    }

    public static void turnOffDebug() {
        debug = false;
    }

    static {
        out = System.out;
        MIN_CLASS_SIZE_TO_LOG = 1048576L;
        SKIP_STATIC_FIELD = false;
        SKIP_FINAL_FIELD = false;
        SKIP_FLYWEIGHT_FIELD = false;
        debug = false;
        unit = new String[]{"b", "Kb", "Mb"};
    }
}