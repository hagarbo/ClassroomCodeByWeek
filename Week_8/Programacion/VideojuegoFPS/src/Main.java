public class Main {

    private static final int DISTANCIA_BOCAJARRO = 3;
    private static final int DISTANCIA_CERCANA = 20;
    private static final int DAMAGE_RATIO = 10;
    private static final int VELOCIDAD_CORTE = 500;

    /*
     * 1. getDamage(int speed, int armor, int distance) : return int --> Esta
     * función debe devolver el daño que ha recibido el personaje. La lógica será la
     * siguiente.
     * - Si la distancia es inferior o igual a 3 metros se considera disparo cercano
     * (ignora armor). Damage = (speed/10)
     * - Si la velocidad de la bala es superior a 500 m/s y la distancia inferior a
     * 20 metros se considera disparo cercano (ignora armor). Damage = (speed/10)
     * - Si la velocidad de la bala es superior a 500 m/s y la distancia es superior
     * a 20 metros, se aplica la siguiente fórmula ((speed/10) - armor) 600/10-100
     * - Para todos los demás casos ((speed/10) - armor+(distance/10) )
     * 
     * NOTA: Si el damage es negativo, se devuelve 0.
     */
    public static int getDamage(int speed, int armor, int distance) {

        if ((distance <= DISTANCIA_BOCAJARRO) || (speed > VELOCIDAD_CORTE && distance < DISTANCIA_CERCANA))
            return (speed / DAMAGE_RATIO);

        if (speed > VELOCIDAD_CORTE && distance > DISTANCIA_CERCANA)
            return Math.max((speed / DAMAGE_RATIO) - armor, 0);

        return Math.max((speed / DAMAGE_RATIO) - (armor + (distance / DAMAGE_RATIO)), 0);
    }

    /*
     * 2. isDeadByBodyShot(int life, int damage) : return boolean --> Esta función
     * simplemente resta el daño recibido a la vida que le queda al personaje. Si al
     * hacer la resta la vida es 0
     * o inferior, el personaje muere.
     */
    public static boolean isDeadByBodyShot(int life, int damage) {
        return ((life - damage) <= 0);
    }

    /*
     * 3. getNumObjects(boolean[][] map) : return int --> Esta función se le pasa
     * como parámetro un mapa de un escenario. Nuestra labor será la de devolver el
     * número de objetos que se han
     * encontrado en el escenario. El mapa es booleano, esto quiere decir que si es
     * false en esa parte del mapa se encuentra paisaje sin relevancia, en cambio,
     * si es true, en esa parte del mapa se encuentra un objeto con el que se puede
     * interactuar.
     */
    public static int getNumObjects(boolean[][] map) {
        int countObject = 0;
        for (boolean[] row : map) {
            for (boolean cell : row) {
                if (cell)
                    countObject++;
            }
        }
        return countObject;
    }

    /*
     * 4. isHit(boolean[][] screen, int y, int x) : return boolean. --> Está función
     * recibe como parámetros la pantalla del jugador y donde ha disparado
     * (coordenadas). La pantalla será parecida
     * a la del ejemplo. Tendremos que devolver si el objetivo ha recibido impacto o
     * no.
     */
    public static boolean isHit(boolean[][] screen, int y, int x) {
        return screen[y][x];
    }

    /*
     * 5. isHeadShot(boolean[][] screen, int y, int x) : return boolean -->
     * Exactamente igual que la anterior, pero en este caso debemos saber si la
     * posición en la que dispara es la columna
     * central de la primera fila del enemigo. En ese caso, el disparo sería en la
     * cabeza y devolveríamos un true.
     */
    public static boolean isHeadShot(boolean[][] screen, int y, int x) {
        return (screen[y][x - 1] && screen[y][x + 1]
                && ((y == 0) || !screen[y - 1][x]));
    }

    /*
     * 6. getEnemyPosition(boolean[][] screen) : return int[2] --> Esta función se
     * le pasa como parámetro la pantalla del jugador cuando está en combate. En
     * cada instante solo puede haber un
     * enemigo ¿Como saber la posición del enemigo en la pantalla? Los enemigos
     * siempre ocuparán un espacio de 3x5 de tal manera que se tiene que devolver el
     * centro de la figura. La función
     * devolverá: Y,X. return ejemplo: 4, 3
     * NOTA: Si no existe enemigo en esos momentos, devolverá 0 0
     */
    public static int[] getEnemyPosition(boolean[][] screen) {
        int[] posicion = { 0, 0 };
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                if (screen[i][j]) {
                    posicion[0] = i + 2;
                    posicion[1] = j + 1;
                    return posicion;
                }
            }
        }
        return posicion;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
