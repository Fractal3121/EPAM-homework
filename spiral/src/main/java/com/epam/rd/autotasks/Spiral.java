package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int [][] a = new int[rows][columns];
        String direction = "right";
        for (int ik = 0; ik < rows; ik++) {
            for (int jk = 0; jk < columns; jk++) {
                switch (direction){
                    case "right":{
                        break;
                    }
                    case "down":{
                        break;
                    }
                    case "left":{
                        break;
                    }
                    case "up":{
                        break;
                    }
                }

            }
        }



//        for (int ik = 0; ik < rows; ik++)
//            for (int jk = 0; jk < columns; jk++)
//                a[ik][jk] = 0;          // заполнив для удобства нулями
//
//        for (int ik = 0; ik < rows; ik++){     //назовем его "Основной цикл"
//            for (int jk = 0; jk < columns; jk++){
//                if (!(ik == 0 || ik == rows - 1 || jk == 0 || jk == columns - 1))
//                    continue;      // Временное условие для фильтрации элементов внесшего "кольца"
//                int i = ik + 1;     // Номера строк и столбцов приводим в удобный
//                int j = jk + 1;     // в математическом плане вид (от 1 до N)
//                //  ... здесь будем вставлять основной код вычислений
//                int switcher =  (j - i + rows) / columns;
//                int Ic = Math.abs(i - rows / 2  - 1) + (i - 1)/(rows /2) * ((columns-1) % 2);
//                int Jc = Math.abs(j - columns / 2  - 1) + (j - 1)/(columns /2) * ((columns-1) % 2);
//                int Ring = rows / 2 - (Math.abs(Ic - Jc) + Ic + Jc) / 2;
//                int Xs = i - Ring + j - Ring - 1;
//                int Coef =  4 * Ring * (rows - Ring);
//                a[ik][jk] =  Coef + switcher * Xs + Math.abs(switcher - 1) * (4 * (rows - 2 * Ring) - 2 - Xs);
//            }
//        }
        return a;
    }
}
