public class Cross {
    public static ResChain cruzar(ResChain cha1n, ResChain cha2n){
        if(cha1n.getSize() != cha1n.getSize()) throw new RuntimeException("Las Cadenas no tiene el mismo tamaño");
        if(cha1n.getSize() != cha1n.getIndice() || cha2n.getIndice() != cha1n.getSize()) throw new RuntimeException("Una de las cadenas no esta completa");
        ResChain result = new ResChain(cha1n.getSize());
        for (int i = 0; i < cha1n.getSize(); i++) {
            if (cha1n.getValue(i) == cha2n.getValue(i)){
                result.Agregate(1);
            } else {
                result.Agregate(0);
            }
        }
        return result;
    }
}
