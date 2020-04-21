package Exception.Example;

public class Main {

    public static void main(String[] args)  {
        Game game = new Game();

        try
        {
            game.saveGame();
        }catch(RuntimeException ex){  //Nota aun que es mejor ser mas especifico en las herramietas que se van a utilizar
                System.out.println(ex.getMessage());
        }/*catch(IndexOutOfBoundsException | NullPointerException ex){ // y este a su vez se puede compactar con el "Run timeException"
            System.out.println(ex.getMessage());
         catch(NullPointerException ex){         este catch se puede compactar en el catch de arriba usando "|"
            System.out.println(ex.getMessage());
        }
         */

    }
}