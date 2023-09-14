public class shipCreator {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];

        ships[0] = new CruiseShip("Cruise Ship 1", "2000", 500);
        ships[1] = new CargoShip("Cargo Ship 1", "1995", 10000);
        ships[2] = new CruiseShip("Cruise Ship 2", "2010", 700);

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }
    }
}
