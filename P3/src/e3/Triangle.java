package e3;

import java.util.Arrays;

public record Triangle (int angle0, int angle1, int angle2) {
    public Triangle {
        if ((angle0 +angle1+angle2)!=180) {
            throw new IllegalArgumentException();
        }
    }
    public Triangle(Triangle t) {
        /*
         * Copy constructor . Constructs a Triangle using another Triangle .
         * @param t The Triangle object to copy .
         */
        this(t.angle0,t.angle1,t.angle2);
    }
    public boolean isRight () {
        /*
         * Tests if a triangle is right .
         * A right triangle has one of its angles measuring 90 degrees .
         * @return True if it is right , false otherwise
         */
        if ((angle0==90)||(angle1==90)) {
            return true;
        } else return (angle2 == 90);
    }
    public boolean isAcute() {
        /*
         * Tests if a triangle is acute .
         * A triangle is acute if all angles measure less than 90 degrees .
         * @return True if it is acute , false otherwise
         */
        if ((angle0<90)&&(angle1<90))
            return (angle2<90);
        else return false;
    }
    public boolean isObtuse() {
        /*
         * Tests if a triangle is obtuse .
         * A triangle is obtuse if it has one angle measuring more than 90 degrees .
         * @return True if it is obtuse , false otherwise
         */
        if ((angle0>90)||(angle1>90))
            return true;
        else return (angle2>90);
    }
    public boolean isEquilateral () {
        /*
         * Tests if a triangle is equilateral .
         * A triangle is equilateral if all the angles are the same .
         * @return True if it is equilateral , false otherwise
         */
        if (angle0==angle1)
            return (angle0==angle2);
        else return false;
    }
    public boolean isIsosceles () {
        /*
         * Tests if a triangle is isosceles .
         * A triangle is isosceles if it has two angles of the same measure .
         * @return True if it is isosceles , false otherwise
         */
        if (angle0==angle1)
            return (angle0!=angle2);
        else if (angle0==angle2)
            return true;
        else return (angle1==angle2);
    }
    public boolean isScalene() {
        /*
         * Tests if a triangle is scalene .
         * A triangle is scalene if it has all angles of different measure .
         * @return True if it is scalene , false otherwise
         */
        if (angle0!=angle1)
            return ((angle0!=angle2)&&(angle1!=angle2));
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        /*
         * Tests if two triangles are equal .
         * Two triangles are equal if their angles are the same ,
         * regardless of the order .
         * @param o The reference object with which to compare .
         * @return True if they are equal , false otherwise .
         */
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else {
            int [] t1; t1 = new int[3];
            t1[0]=this.angle0; t1[1]=this.angle1; t1[2]=this.angle2;
            Arrays.sort(t1); //we order the array
            int [] t2; t2 = new int[3];
            t2[0]=((Triangle) o).angle0; t2[1]=((Triangle) o).angle1; t2[2]=((Triangle) o).angle2;
            Arrays.sort(t2); //we order the array
            return Arrays.equals(t1, t2);
        }
    }

    @Override
    public int hashCode() {
        /*
         * Hashcode function whose functioning is consistent with equals .
         * Two triangles have the same hashcode if their angles are the same ,
         * regardless of the order .
         * @return A value that represents the hashcode of the triangle .
         */
        int[] tr; tr = new int[3];
        tr[0]=angle0; tr[1]=angle1; tr[2]=angle2;
        Arrays.sort(tr); //we order the array
        return Arrays.hashCode(tr);
    }
}
