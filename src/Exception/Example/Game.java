package Exception.Example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    private static final String FORMAT_FOR_DATES = "yyy/MM/dd HH:mm:ss";
    private static final String FORMAT_NAME_SCORE = "score.txt";
    private static final String FORMAT_NAME_PROGRESS = "progress.txt";
    private static final String FORMAT_NAME_STATISTICS = "statistics.txt";

    public void saveGame() {
        try {
            saveProgress();
            saveScore();
            saveStatistics();
        } catch (SaveProgressException ex) { //ex tener la informacion de que ocurrio
            System.err.println("Can´t save progress" + ex.getMessage());
        } catch (SaveScoreException ex) {
            ex.printStackTrace();
            //System.err.println("Can´t save score" + ex.getMessage());
        } catch (SaveStatisticsException ex) {
            System.err.println("Can´t save statistics" + ex.getMessage());
        }
    }

    private void saveStatistics() throws SaveStatisticsException {

        try(FileWriter writer = new FileWriter(FORMAT_NAME_STATISTICS, true);) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
         

        } catch (IOException ex) {
            throw new SaveStatisticsException();
        }
    }

    private void saveScore() throws SaveScoreException {

        try(FileWriter writer = new FileWriter(FORMAT_NAME_SCORE, true);) {
            LocalDateTime now= LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            throw new IOException("IO exception de prueba");
        } catch (IOException e) {
            throw new SaveScoreException("el mensaje", e);
        }
    }

    private void saveProgress() throws SaveProgressException {
        //FileWriter writer = null; // esta debe borrarse ya que debe crearse desde el try
        try(FileWriter writer = new FileWriter(FORMAT_NAME_PROGRESS, true);) { // se pasa a esta parte
            LocalDateTime now= LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            //writer = new FileWriter(FORMAT_NAME_PROGRESS, true      **donde se crea el archivo se pasa al try
             writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
            //writer.close(); se borra ya que es inecesario este close

        } catch (IOException ex) {
            throw new SaveProgressException();
        }/*finally {
            if (writer != null) {
                try {
                    writer.close();                    //esta parte ya no se necesita gracias al try con recursos
                } catch (IOException ex) {

                }
            }
        }*/
    }
}
