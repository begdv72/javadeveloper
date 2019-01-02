public class Ship {
    int size;
    int position;
    int SHIP_SIZE = 3;
    int FIELD_SIZE = 10;

    Ship(int size, int position) {
        this.size = size;
        this.position = position;
    }
//Отображение корабля на игровом поле
    public void show(char[] cells) {
        for (int i = position; i < position + size; i++)
            cells[i - 1] = 'X';
    }
//Корабль потоплен?
    public boolean hitted(char[] cells) {
        boolean result = true;
        for (int i = position; i < position + size; i++) {
            if (cells[i - 1] != '#') {
                result = false;
                break;
            }
        }
        return result;
    }
}

