import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MiListaDoble lista = new MiListaDoble();

        System.out.println("¿Vacía? " + lista.isEmpty());

        // add / insertHead / insertTail
        lista.add(999);
        lista.add(10000);
        lista.insertHead(7000);
        lista.insertTail(100000);
        System.out.println("Lista: " + lista + "  tamaño=" + lista.getSize());
        System.out.println("Cabeza=" + lista.getHead() + "  Cola=" + lista.getTail());

        // search / get / contains
        DoubleNode n999 = lista.search(999);
        System.out.println("get" + lista.get(n999));
        System.out.println("¿Contiene 999? " + lista.contains(999));
        System.out.println("¿Contiene 99? " + lista.contains(99));

        // insert
        lista.insert(n999, 35);
        lista.insert((Object) 999, 25);
        System.out.println("Tras insertar 35 y 25: " + lista);

        // set
        lista.set(lista.search(35), 36);
        System.out.println("Tras set 35->36: " + lista);

        // remove
        lista.remove(lista.search(10000));   // cabeza
        lista.remove(lista.search(100000));   // cola
        System.out.println("Tras remover 10000 y 100000: " + lista);

        // toArray
        System.out.println("toArray: " + Arrays.toString(lista.toArray()));
        Integer[] destino = new Integer[0];
        destino = (Integer[]) lista.toArray(destino);
        System.out.println("toArray(Integer[]): " + Arrays.toString(destino));

        // subList
        MiListaDoble sub = lista.subList(lista.search(999), lista.search(25));
        System.out.println("subList(999..25)" + sub);

        // sortList
        System.out.println("Ordenada: " + lista.sortList());
        System.out.println("Original sigue igual: " + lista);

        // clear
        lista.clear();
        System.out.println("Tras clear -> vacía? " + lista.isEmpty() + "  tamaño=" + lista.getSize());
    }
}
