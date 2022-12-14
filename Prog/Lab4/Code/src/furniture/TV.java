package furniture;

import exceptions.WrongTVChannelException;
import persons.Julio;
import persons.Shortling;
import persons.Sproots;

import java.util.Arrays;
import java.util.Scanner;

public class TV extends Furniture {

    private boolean watchedChannelThreeTogether;

    {
        watchedChannelThreeTogether = false;
    }

    public void setWatchedChannelThreeTogether(boolean watched) {
        watchedChannelThreeTogether = watched;
    }

    public boolean isWatchedChannelThreeTogether() {
        return watchedChannelThreeTogether;
    }

    public TV() {
        super("обычный");
        System.out.println("Есть обычный телевизор.");
    }

    public TV(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " телевизор.");
    }

    private void watchChannelOne() {
        class Programme {
            final static String content = "\"...рабочие! Теперь, без своих господ, " +
                    "они сами управляют фабриками и заводами. "+
                    "А многие производственные процессы теперь протекают в невесомости!\"";
        }
        System.out.println("Вот, что показывают по первому каналу:");
        System.out.println(Programme.content);
        System.out.println("Ужас, как можно было такое допустить?!");
    }

    private void watchChannelTwo() {
        class Programme {
            final static String content = "\"...растения! Только посмотрите, до каких размеров их удалось вырастить!" +
                    " Все эти гигантские культуры растут на землях, ранее принадлежащих богачам!\"";
        }
        System.out.println("Вот, что показывают по второму каналу:");
        System.out.println(Programme.content);
        System.out.println("От всех этих гигантских огурцов и арбузов становится не по себе. Возмутительно!");
    }

    private void watchChannelThree(Sproots sproots) {
        System.out.println("По третьему каналу не показывают ничего интересного. " + sproots.getName() +
                " зевает.");
    }

    private void watchChannelThree(Sproots sproots, Julio julio) {
        System.out.println("Вот, что показывают по третьему каналу:");
        System.out.println("\"А сейчас мы покажем недавно прибывших космонавтов!\"");
        System.out.println(sproots.getName() + " и " + julio.getName() + " сразу насторожились" +
                " и уселись поудобнее. Сейчас что-то будет!");
        Shortling znayka = new Shortling() {
            @Override
            public void tell() {
                System.out.println("\"...Знайка! Да, так меня зовут! Со мной мои друзья-коротышки с Земли, " +
                        "а вот наши домики, мы их сами построили!\"");
                System.out.println("Дальше показали один из домиков изнутри.");
            }
        };
        Shortling fooxia = new Shortling() {
            @Override
            public void tell() {
                System.out.println("\"А я Фуксия! Мы тут не абы-чем, а наукой, вообще-то, занимаемся! Вот как!\"");
                System.out.println("Показали несколько научных приборов.");
            }
        };
        Shortling tubik = new Shortling() {
            @Override
            public void tell() {
                System.out.println("\"Меня Тюбиком зовут... Взгляните на земные пейзажи! Разве не чудесно?\"");
                System.out.println("Показали картины, а потом Тюбик рассказал об особенностях жизни на Земле.");
            }
        };
        Shortling gooslya = new Shortling() {
            @Override
            public void tell() {
                System.out.println("\"А я Райан Гуслинг! Ха-ха, шучу! Гусля я!\"");
                System.out.println("Гусля сыграл в конце программы, но не в ящик, как некоторые могли подумать," +
                        " а на флейте.");
            }
        };

        znayka.tell();
        System.out.println(sproots.getName() + " и " + julio.getName() + " сразу узнали своего главного врага.");
        fooxia.tell();
        System.out.println("\"Чтоб им всем пусто было!\" - думали "
                + sproots.getName() + " и " + julio.getName() + '.');
        tubik.tell();
        System.out.println("Дурацкие картины! " + sproots.getName() + " и " + julio.getName() +
                " уже кипели от злости.");
        gooslya.tell();
        System.out.println("\"Ну всё!\" - крикнул " + sproots.getName() + ", вскочив и выключив телевизор." +
                " \"Хватит этой ерунды!\"");
    }

    private String chooseChannel() {
        System.out.println("Выберите канал (1, 2, или 3). Осторожно, телевизор барахлит!");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        String[] channels = new String[] {"1", "2", "3"};
        if (!Arrays.asList(channels).contains(answer)) {
            throw new WrongTVChannelException("Такого канала нет! Телевизор зашипел и взорвался!" +
                    " Всё! Конец!");
        }
        return answer;
    }

    public void watch(Sproots sproots) {
        System.out.println("Теперь хорошо бы посмотреть телевизор. Что " + sproots.getName() +
                " сегодня будет смотреть?");
        String answer = chooseChannel();
        switch (answer) {
            case "1" -> watchChannelOne();
            case "2" -> watchChannelTwo();
            case "3" -> watchChannelThree(sproots);
        }
    }

    public void watch(Sproots sproots, Julio julio) {
        System.out.println("Теперь хорошо бы посмотреть телевизор. Что " + sproots.getName() +
                " и " + julio.getName() + " будут сегодня смотреть?");
        String answer = chooseChannel();
        switch (answer) {
            case "1" -> watchChannelOne();
            case "2" -> watchChannelTwo();
            case "3" -> {
                watchChannelThree(sproots, julio);
                setWatchedChannelThreeTogether(true);
            }
        }
    }

}
