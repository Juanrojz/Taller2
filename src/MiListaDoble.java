import java.lang.reflect.Array;
import java.util.Arrays;


public class MiListaDoble implements ListInterface {

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public MiListaDoble(){

        head=null;
        tail=null;
        size=0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;

    }

    @Override
    public Object getHead() {
        // condicion ? si es verdadero: si es falso osea lee si node es null devuelve null; si no devuelve node.dato es como un if
        return head == null ? null :head.dato;

    }

    @Override
    public Object getTail() {
        return tail == null ? null :tail.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        return node == null ? null: node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode actual = head;
        while (actual != null) {
            if (iguales(actual.dato, object)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;

    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        if (node == tail) {
            return insertTail(object);
        }
        DoubleNode nuevo = new DoubleNode(object);
        nuevo.anterior = node;
        nuevo.siguiente = node.siguiente;
        node.siguiente.anterior = nuevo;
        node.siguiente = nuevo;
        size++;
        return true;

    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode ref = search(objectRef);
        return insert(ref, object);

    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.siguiente = head;
            head.anterior = nuevo;
            head = nuevo;
        }
        size++;
        return true;

    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.anterior = tail;
            tail.siguiente = nuevo;
            tail = nuevo;
        }
        size++;
        return true;

    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;

    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) {
            return false;
        }
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.siguiente;
            head.anterior = null;
        } else if (node == tail) {
            tail = node.anterior;
            tail.siguiente = null;
        } else {
            node.anterior.siguiente = node.siguiente;
            node.siguiente.anterior = node.anterior;
        }
        node.anterior = null;
        node.siguiente = null;
        size--;
        return true;

    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[size];
        int i = 0;
        for (DoubleNode actual = head; actual != null; actual = actual.siguiente) {
            arreglo[i++] = actual.dato;
        }
        return arreglo;

    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object.length < size) {
            object = (Object[]) Array.newInstance(object.getClass().getComponentType(), size);
        }
        int i = 0;
        for (DoubleNode actual = head; actual != null; actual = actual.siguiente) {
            object[i++] = actual.dato;
        }
        if (object.length > size) {
            object[size] = null;
        }
        return object;

    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        if (from == null || to == null) {
            return null;
        }
        MiListaDoble sub = new MiListaDoble();
        DoubleNode actual = from;
        while (actual != null) {
            sub.add(actual.dato);
            if (actual == to) {
                return sub;
            }
            actual = actual.siguiente;
        }
        return null; // "to" no
    }

    @Override
    public MiListaDoble sortList() {
        Object[] arreglo = toArray();
        Arrays.sort(arreglo);
        MiListaDoble ordenada = new MiListaDoble();
        for (Object o : arreglo) {
            ordenada.add(o);
        }
        return ordenada;

    }
    private boolean iguales(Object a, Object b) {
        return a == null ? b == null : a.equals(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (DoubleNode actual = head; actual != null; actual = actual.siguiente) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();

    }
}