public class Ship {
    int size;
    int position;

    Ship(int size, int position) {
        this.size = size;
        this.position = position;
    }

    //Отображение корабля на игровом поле
    public void show(char[] cells) {
        for (int i = this.position; i < this.position + this.size; i++)
            cells[i - 1] = 'X';
    }

    //Корабль потоплен?
    public boolean hitted(char[] cells) {
        boolean result = true;
        for (int i = this.position; i < this.position + this.size; i++) {
            if (cells[i - 1] != '#') {
                result = false;
                break;
            }
        }
        return result;
    }

    //Ячейки поля, на которые нельзя размещать другие корабли
    public boolean isOccupied(int position, int size) {
        return (((position + size) >= this.position - 1) && (position <= this.position + this.size + 1));
    }

    //Ячейки поля, занятые кораблем
    public boolean isPlace(int position) {
        return ((position >= this.position) && (position <= this.position + this.size));
    }
}
