import java.util.Arrays;

public class ResChain {

    private Integer[] cadena;

    private Integer sizes,indice, valorCadena;

    public int getSize() {
        return sizes;
    }
    public int getIndice() {
        return indice;
    }
    public Integer getValue(int indice) {
        return this.cadena[indice];
    }

    public ResChain(int tam) {
        this.sizes = tam;
        this.cadena = new Integer[this.sizes];
        indice = 0;
    }

    @Override
    public String toString() {
        
        return  "\n\t\t╔═════════════════════════════════════════════════════════╗" +
                "\n\t\t║Cadena Resultante                                        ║" +
                "\n\t\t╚═════════════════════════════════════════════════════════╝"+
                "\n\t\tValores en la Cadena => " + Arrays.toString(cadena) +
                "\n\t\tValor total de cadena => " + this.evaluateChain() +
                "\n\t\tValor del indice => " + this.indice +
                "\n\t\tTamaño total permitido de la cadena => " + this.sizes +
                "\n══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════";
                
    }

    public void Agregate(int valor){
        if(this.indice >= this.sizes){
            throw new IndexOutOfBoundsException("El nuevo valor ingresado supera el tamaño permitido de la cadena");
        }
        this.cadena[this.indice] = valor;
        this.indice++;
    }

    public int evaluateChain(){
        if (this.sizes != this.indice) return 0;
        if (this.valorCadena == null) {
            int sumatoria = 0;
            for (int i = 0; i < this.sizes; i++) {
                sumatoria += this.cadena[i] * 2;
            }
            this.valorCadena = sumatoria;
            return sumatoria;
        } else {
            return this.valorCadena;
        }
    }
}
