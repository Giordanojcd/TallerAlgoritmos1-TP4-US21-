import java.util.Random;

public class Genetic {

    private ResChain first;
    private Integer iteraciones;

    public Genetic() {
        this.first = this.GenChain();
        this.iteraciones = 0;
    }

    public ResChain GenChain() {
        ResChain NewChain = new ResChain(20);
        for (int i = 0; i < 20; i++) {
            NewChain.Agregate(this.Random());
        }
        return NewChain;
    }

    private int Random(){
        Random random = new Random();
        return random.nextInt(2); // el limite maximo es 2 ya que en la funcion random 2 el limite es exclusivo
    }

    public void process() {
        if(this.first == null) this.first = this.GenChain();
        System.out.println("\t\t\t\t╔═════════════════════════════════════════════════════════╗");
        System.out.println("\t\t\t\t║     BIENVENIDO AL                                       ║");
        System.out.println("\t\t\t\t║                  TRABAJO PRACTICO Nº4                   ║");
        System.out.println("\t\t\t\t╚═════════════════════════════════════════════════════════╝");
        System.out.println("\t\t\t\t║         USER: Giordano, Juan Carlos Daniel              ║");
        System.out.println("\t\t\t\t║                     VINF011535                          ║");
        System.out.println("\t\t\t\t╚═════════════════════════════════════════════════════════╝");
        System.out.println("Generando parametros para definir la cadena");
        System.out.println("Cadena creada: \n\t" + this.first);
                System.out.println("Empezando proceso con la cadena");
        while (this.first.evaluateChain() < 40){
            ResChain NewChain = this.GenChain();
            ResChain ChainCruz = Cross.cruzar(this.first,NewChain);
            if(ChainCruz.evaluateChain() > this.first.evaluateChain()){
                System.out.printf("NEW!!!\n Cadena Cruzada Principal valor => %d \n" +
                        "Valor Cadena anterior => %d\n" ,
                            ChainCruz.evaluateChain(),
                            this.first.evaluateChain());
                this.first = ChainCruz;
                System.out.println("CADENA NUEVA PRINCIPAL RESULTANTE:\n\t" + this.first);
            }
            this.iteraciones++;
        }
        System.out.println("La cantidad de iteraciones necesarias para lograr una cadena con valor igual a 40 es -> " + this.iteraciones);
    }
}
