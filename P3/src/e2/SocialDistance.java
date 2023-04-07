package e2;

import java.util.Arrays;

public class SocialDistance {
    public static char[][] seatingPeople (char[][] layout) {
        /*
         * Given the layout of a class with available sites marked with an ’A’ and
         * invalid sites marked with a ’. ’, returns the resulting layout with the
         * sites occupied by the students marked with a ’#’ following two rules :
         * - Students occupy an empty seat if there are no other adjacent students .
         * - A student leaves a seat empty if he/ she has 4 or more adjacent students .
         * @param layout The initial layout .
         * @return The resulting layout .
         * @throws IllegalArgumentException if the initial layout is invalid (is null ,
         * is ragged , includes characters other than ’.’ or ’A ’)).
         */
        if (layout==null) { //in case layout is null:
            throw new IllegalArgumentException();
        }
        else {
            if (checkSizes(layout)) { //we call the function that proves that the class size is correct
                if (checkCharacter(layout)) { //we call the function that checks us that the characters are correct
                    char[][] aux1 = new char[layout.length][layout[0].length]; //we initialize the variable
                    char[][] aux2 = new char[layout.length][layout[0].length]; //we initialize the variable
                    boolean differentArrays=true;
                    for (int k = 0; k < layout.length; k++) { //we copy layout en aux1:
                        System.arraycopy(layout[k], 0, aux1[k], 0, layout[0].length);
                    }
                    sitAll(layout); //we sit all the students using an auxiliary function
                    if (!Arrays.deepEquals(layout, aux1)) {  //if they were the same it would imply that no one has been able to sit down from the beginning
                        while (differentArrays) { //as long as someone can get up or sit:
                            for (int f = 0; f < layout.length; f++) { //We copy in aux2 the layout content
                                System.arraycopy(layout[f], 0, aux2[f], 0, layout[0].length);
                            }
                            gettingUp(layout); //We lift the students following the rules using an auxiliary function
                            applyingDistance(layout); //we sit the students following the rules using an auxiliary function
                            if (Arrays.deepEquals(layout, aux2)) {
                                differentArrays=false;
                            }
                            //if no one has sat or lifted, it means that we already have the final model
                        }
                    }
                    return layout;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }
    public static boolean checkSizes (char[][] layout) {
        boolean correct=true;
        //we check that all rows have the same number of columns:
        for (int i=0; (i < layout.length-1)&&(correct); i++) {
            if (layout[i].length!=layout[i+1].length) {
                correct=false;
            }
        }
        return correct;
    }
    public static boolean checkCharacter (char[][] layout) {
        //we check that there are only characters 'A' or '.'
        boolean correct=true;
        for (int i = 0; i < (layout.length)&&(correct); i++) {
            for (int j = 0; j < (layout[0].length)&&(correct); j++) {
                if ((layout[i][j]!='.') && (layout[i][j]!='A')) {
                    correct=false;
                }
            }
        }
        return correct;
    }
    public static void sitAll (char[][] layout) {
        //we sit all the students where there is a site available:
        for (int i=0; i < layout.length; i++) {
            for (int j=0; j < layout[0].length; j++) {
                if (layout[i][j]=='A') {  //we change all the 'A' to '#'
                    layout[i][j]='#';
                }
            }
        }
    }
    public static void gettingUp (char[][] layout) {
        int l,h;
        h=layout.length; //rows
        l=layout[0].length; //columns
        //in case the class is only one line, students can sit in any available seat
        if ((h!=1)&&(l!=1)) {
            char[][] aux = new char[layout.length][layout[0].length]; //we initialize the variable
            for (int k=0; k < layout.length; k++) {
                System.arraycopy(layout[k], 0, aux[k], 0, layout[0].length);
            }
            for (int i=0; i < layout.length; i++) {
                for (int j=0; j < layout[0].length; j++) {
                    int no_site=0; //next student counter
                    //side cases without being corners:
                    if((i==0)&&(j!=0)) { //upper side:
                        if (j!=l-1) {
                            if (layout[i][j]=='#')  {
                                if (layout[i][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j] == '#') {
                                    ++no_site;
                                }
                                if (layout[i][j + 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j + 1] == '#') {
                                    ++no_site;
                                }
                            }
                        }
                    }
                    if ((j==0)&&(i!=0)) { //left side
                        if (i<h-1) {
                            if (layout[i][j]=='#') {
                                if (layout[i-1][j]=='#') {
                                    ++no_site;
                                }
                                if (layout[i+1][j]=='#') {
                                    ++no_site;
                                }
                                if (layout[i-1][j+1]=='#') {
                                    ++no_site;
                                }
                                if (layout[i][j+1]=='#') {
                                    ++no_site;
                                }
                                if (layout[i+1][j+1]=='#') {
                                    ++no_site;
                                }
                            }
                        }
                    }
                    if ((i==h-1)&&(j!=0)) { //lower side
                        if (j<l-1) {
                            if (layout[i][j] == '#') {
                                if (layout[i-1][j-1]=='#') {
                                    ++no_site;
                                }
                                if (layout[i][j-1]=='#') {
                                    ++no_site;
                                }
                                if (layout[i-1][j]=='#') {
                                    ++no_site;
                                }
                                if (layout[i-1][j+1]=='#') {
                                    ++no_site;
                                }
                                if (layout[i][j+1]=='#') {
                                    ++no_site;
                                }
                            }
                        }
                    }
                    if ((j==l-1)&&(i!=0)) { //right side
                        if (i<h-1) {
                            if (layout[i][j]=='#') {
                                if (layout[i - 1][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i - 1][j] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j] == '#') {
                                    ++no_site;
                                }
                            }
                        }
                    }
                    if ((i>0)&&(j>0)) {  //case for interior boxes
                        if ((i<h-1)&&(j<l-1)) {
                            if (layout[i][j] == '#') {
                                if (layout[i - 1][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j - 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i - 1][j] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j] == '#') {
                                    ++no_site;
                                }
                                if (layout[i - 1][j + 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i][j + 1] == '#') {
                                    ++no_site;
                                }
                                if (layout[i + 1][j + 1] == '#') {
                                    ++no_site;
                                }
                            }
                        }
                    }
                    if (no_site>=4) { //if there are 4 or more students nearby, it gets up
                        aux[i][j]='A';
                    }
                }
            }
            for (int k=0; k < layout.length; k++) {
                System.arraycopy(aux[k], 0, layout[k], 0, layout[0].length);
            }
        }
    }
    public static void applyingDistance (char[][] layout) {
        int l,h;
        h=layout.length; //rows
        l=layout[0].length; //columns
        if ((h!=1)&&(l!=1)) { //in case the class is only one line, students can sit in any available seat
            char[][] aux = new char[layout.length][layout[0].length]; //we initialize the variable
            for (int k=0; k < layout.length; k++) {
                System.arraycopy(layout[k], 0, aux[k], 0, layout[0].length);
            }
            for (int i=0; i < layout.length; i++) {
                for (int j=0; j < layout[0].length; j++) {
                    int control=0;
                    //we check the side boxes, without taking into account the corners
                    if((i==0)&&(j!=0)) { //upper side
                        if (j<l-1) {
                            if (layout[i][j]=='A')  {
                                if (layout[i][j - 1] == '#') { //We check if there are adjacent students
                                    ++control;
                                } else if (layout[i + 1][j - 1] == '#') {
                                    ++control;
                                } else if (layout[i + 1][j] == '#') {
                                    ++control;
                                } else if (layout[i][j + 1] == '#') {
                                    ++control;
                                } else if (layout[i + 1][j + 1] == '#') {
                                    ++control;
                                }
                            }
                        }
                    }
                    if ((j==0)&&(i!=0)) { //left side
                        if (i<h-1) {
                            if (layout[i][j]=='A') {
                                if (layout[i-1][j]=='#') { //We check if there are adjacent students
                                    ++control;
                                } else if (layout[i+1][j]=='#') {
                                    ++control;
                                } else if (layout[i-1][j+1]=='#') {
                                    ++control;
                                } else if (layout[i][j+1]=='#') {
                                    ++control;
                                } else if (layout[i+1][j+1]=='#') {
                                    ++control;
                                }
                            }
                        }
                    }
                    if ((i==h-1)&&(j!=0)) { //lower side
                        if (j<l-1) {
                            if (layout[i][j] == 'A') { //We check if there are adjacent students
                                if (layout[i-1][j-1]=='#') {
                                    ++control;
                                } else if (layout[i][j-1]=='#') {
                                    ++control;
                                } else if (layout[i-1][j]=='#') {
                                    ++control;
                                } else if (layout[i-1][j+1]=='#') {
                                    ++control;
                                } else if (layout[i][j+1]=='#') {
                                    ++control;
                                }
                            }
                        }
                    }
                    if ((j==l-1)&&(i!=0)) { //right side
                        if (i<h-1) {
                            if (layout[i][j]=='A') { //We check if there are adjacent students
                                if (layout[i - 1][j - 1] == '#') {
                                    ++control;
                                } else if (layout[i][j - 1] == '#') {
                                    ++control;
                                } else if (layout[i + 1][j - 1] == '#') {
                                    ++control;
                                } else if (layout[i - 1][j] == '#') {
                                    ++control;
                                } else if (layout[i + 1][j] == '#') {
                                    ++control;
                                }
                            }
                        }
                    }
                    if ((i>0)&&(j>0)) {  //we check the interior sites
                        if ((i<h-1)&&(j<l-1)) {
                            if (layout[i][j]=='A') {
                                if (layout[i-1][j-1]=='#') { //We check if there are adjacent students
                                    ++control;
                                } else if (layout[i][j-1]=='#') {
                                    ++control;
                                } else if (layout[i+1][j-1]=='#') {
                                    ++control;
                                } else if (layout[i-1][j]=='#') {
                                    ++control;
                                } else if (layout[i+1][j]=='#') {
                                    ++control;
                                } else if (layout[i-1][j+1]=='#') {
                                    ++control;
                                } else if (layout[i][j+1]=='#') {
                                    ++control;
                                } else if (layout[i+1][j+1]=='#') {
                                    ++control;
                                }
                            }
                        }
                    }
                    if (layout[i][j]=='A') { //as long as there is only one adjacent student sitting, he could not sit
                        if (control==0) {
                            aux[i][j]='#';
                        }
                    }
                }
            }
            for (int k=0; k < layout.length; k++) {
                System.arraycopy(aux[k], 0, layout[k], 0, layout[0].length);
            }
        }
    }

}