import java.util.Scanner;
public class PracticaEstructura {
    Scanner teclat=new Scanner(System.in);

    public static void main(String[] args) {

        PracticaEstructura pe=new PracticaEstructura();
        //Crear un array de la classe Persona
        Persona[] empresa=new Persona[10];
        int index=0;
        index=pe.introduir(empresa,index);
        index=pe.introduir(empresa,index);
        pe.imprimeix(empresa,index);
    }

    public int introduir(Persona[] empresa,int index){
        System.out.print("Nom:");
        String nom=teclat.next();
        System.out.print("Cognom:");
        String cognom=teclat.next();
        System.out.print("Edat:");
        int edat=teclat.nextInt();
        System.out.print("Sou:");
        double sou=teclat.nextDouble();
        // Crear una persona i donar-li valors
        Persona p=new Persona(nom, cognom, edat, sou);
        //Guardar persona p en l'array
        empresa[index]=p;
        index++;
        return index;
    }

    public void imprimeix(Persona[] empresa,int index){
        System.out.println("------------ Llistat ..................");
        for (int i = 0; i <index; i++) {
            System.out.println("Nom:"+empresa[i].getNom());
            System.out.println("Cognom:"+empresa[i].getCognom());
            System.out.println("Edat:"+empresa[i].getEdat());
            System.out.println("Sou:"+empresa[i].getSou());
            System.out.println("");
        }
    }
}