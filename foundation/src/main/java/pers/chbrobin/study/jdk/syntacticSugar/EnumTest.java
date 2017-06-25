package pers.chbrobin.study.jdk.syntacticSugar;

enum EnumTest {
    MALE {
        public String toString() {
            return "我是男人";
        }
    },
    FEMALE {
        public String toString() {
            return "我是女人";
        }
    };
}
