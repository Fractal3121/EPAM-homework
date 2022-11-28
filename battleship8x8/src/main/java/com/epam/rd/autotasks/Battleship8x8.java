package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        if (shot.equals("A1")) return firstshot(shot);
        int a1 = (shots < 0 || shots == Long.MAX_VALUE) ? -1 : 1;

        String shootB = byteString(shot);
        long c = Long.parseLong(shootB, 2);
        if (shots == Long.MAX_VALUE) {
            shots = 0L;
        }
        shots = shots + (a1 * c);

        return (c & (-1 * ships)) == 0 && (c & ships) != 0;
        //throw new UnsupportedOperationException();
    }

    public String state() {
        StringBuilder sb = new StringBuilder();
        int a1 = shots > 0 ? 1 : -1;
        long c = 1L;
        for (int i = 0; i < 63; i++) {
            long j = (c << i);
            if ((j & ships) == 0 && (j & shots*a1) == 0) {sb.append('.');}
            if ((j & ships) == 0 && (j & shots*a1) != 0) {sb.append('×');}
            if ((j & ships) != 0 && (j & shots*a1) == 0) {sb.append('☐');}
            if ((j & ships) != 0 && (j & shots*a1) != 0) {sb.append('☒');}
        }
        if (shots>0 && ships>0) {sb.append('.');}
        if (shots<0 && ships>0) {sb.append('×');}
        if (shots>0 && ships<0) {sb.append('☐');}
        if ((shots<0 && ships<0)) {sb.append('☒');}

        sb.reverse();
        sb.insert(8, "\n");
        sb.insert(17, "\n");
        sb.insert(26, "\n");
        sb.insert(35, "\n");
        sb.insert(44, "\n");
        sb.insert(53, "\n");
        sb.insert(62, "\n");

        return sb.toString();
        //throw new UnsupportedOperationException();
    }

    private String byteString(String shot) {
        byte[][] array = new byte[8][8];
        int a;
        int b;
        b = Character.getNumericValue(shot.charAt(0)) - 10;
        a = Character.getNumericValue(shot.charAt(1)) - 1;
        array[a][b] = 1;

        StringBuilder sb = new StringBuilder();
        for (a = 0; a < 8; a++) {
            for (b = 0; b < 8; b++) {
                sb.append(array[a][b]);
            }
        }
        return sb.toString();
    }

    private boolean firstshot(String shot) {
        String nextshot = byteString(shot).substring(1);
        if (shots > 0) { shots = -shots; }
        else { shots = Long.MAX_VALUE; }

        return ships < 0;
    }
}
