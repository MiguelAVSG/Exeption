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
            System.err.println("Can´t save score" + ex.getMessage());
        } catch (SaveStatisticsException ex) {
            System.err.println("Can´t save statistics" + ex.getMessage());
        }
    }

    private void saveStatistics() throws SaveStatisticsException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer = new FileWriter(FORMAT_NAME_STATISTICS, true);
            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
            writer.close();

        } catch (IOException ex) {
            throw new SaveStatisticsException();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {

                }
            }
        }
        throw new IndexOutOfBoundsException("IndexOutOfBoundsException throw just because");
    }

    private void saveScore() throws SaveScoreException {
        FileWriter writer = null;
        try {
            LocalDateTime now= LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer = new FileWriter(FORMAT_NAME_SCORE, true);
            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
            writer.close();

        } catch (IOException ex) {
            throw new SaveScoreException();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {

                }
            }
        }
    }

    private void saveProgress() throws SaveProgressException {
        FileWriter writer = null;
        try {
            LocalDateTime now= LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer = new FileWriter(FORMAT_NAME_PROGRESS, true);
            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
            writer.close();

        } catch (IOException ex) {
            throw new SaveProgressException();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {

                }
            }
        }
    }


}
