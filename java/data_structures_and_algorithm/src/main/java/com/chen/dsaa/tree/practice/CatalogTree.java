package com.chen.dsaa.ch04.practice;

public class CatalogTree {
    Catalog element;
    CatalogTree firstChild;
    CatalogTree nextSibling;

    CatalogTree(Catalog rootElement) {
        element = rootElement;
    }

    class Catalog implements Comparable<Catalog> {
        String code;
        String name;

        Catalog(String code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public int compareTo(Catalog other) {
            int intCode1 = Integer.valueOf(this.code);
            int intCode2 = Integer.valueOf(other.code);
            if (intCode1 > intCode2)
                return 1;
            else if (intCode1 == intCode2)
                return 0;
            else
                return -1;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Catalog))
                return false;
            Catalog other = (Catalog)object;
            return compareTo(other) == 0 ? true : false;
        }
    }
}
