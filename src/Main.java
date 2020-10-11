import java.sql.Timestamp;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(final String[] args) {
        boolean cont = true;
        Scanner input = new Scanner(System.in);
        DispHelp();
        while (cont) {
            System.out.print(">");
            String inp = input.nextLine();
            StringTokenizer cmd_line = new StringTokenizer(inp);
            int num_of_tokens = cmd_line.countTokens();
            if (num_of_tokens == 0)
                continue;
            String cmd = cmd_line.nextToken().toLowerCase();
            switch (cmd) {
                case "list":{
                    Table st = new Table();
                    st.setRightAlign(true);
                    st.setShowVerticalLines(true);
                    st.setHeaders("table");
                    for (int i = 0; i < requestSql.get_tables().size(); i++) {
                        st.addRow("" + requestSql.get_tables().get(i));
                    }
                    st.print();
                    break;
                }
                case "show": {
                    if(cmd_line.countTokens() == 0){
                        System.out.println("Не задано имя таблицы");
                        continue;
                    }
                    switch (cmd_line.nextToken().toLowerCase()) {
                        case "department" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "address", "balance", "region");
                            for (int i = 0; i < requestSql.get_departments().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_departments().get(0).get(i),
                                        "" + requestSql.get_departments().get(1).get(i),
                                        "" + requestSql.get_departments().get(2).get(i),
                                        "" + requestSql.get_departments().get(3).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "account" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("number", "balance");
                            for (int i = 0; i < requestSql.get_account().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_account().get(0).get(i),
                                        "" + requestSql.get_account().get(1).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "atm" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "balance", "address");
                            for (int i = 0; i < requestSql.get_atm().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_atm().get(0).get(i),
                                        "" + requestSql.get_atm().get(1).get(i),
                                        "" + requestSql.get_atm().get(2).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "additional_services" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "cost", "name");
                            for (int i = 0; i < requestSql.get_additional_services().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_additional_services().get(0).get(i),
                                        "" + requestSql.get_additional_services().get(1).get(i),
                                        "" + requestSql.get_additional_services().get(2).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "region" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "name");
                            for (int i = 0; i < requestSql.get_region().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_region().get(0).get(i),
                                        "" + requestSql.get_region().get(1).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "client" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "name", "number", "balance", "region", "service");
                            for (int i = 0; i < requestSql.get_client().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_client().get(0).get(i),
                                        "" + requestSql.get_client().get(1).get(i),
                                        "" + requestSql.get_client().get(2).get(i),
                                        "" + requestSql.get_client().get(3).get(i),
                                        "" + requestSql.get_client().get(4).get(i),
                                        "" + requestSql.get_client().get(5).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "employee" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "name", "post", "salary", "adress");
                            for (int i = 0; i < requestSql.get_employee().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_employee().get(0).get(i),
                                        "" + requestSql.get_employee().get(1).get(i),
                                        "" + requestSql.get_employee().get(2).get(i),
                                        "" + requestSql.get_employee().get(3).get(i),
                                        "" + requestSql.get_employee().get(4).get(i));
                            }
                            st.print();
                            break;
                        }
                        case "post" : {
                            Table st = new Table();
                            st.setRightAlign(true);
                            st.setShowVerticalLines(true);
                            st.setHeaders("id", "name");
                            for (int i = 0; i < requestSql.get_post().get(0).size(); i++) {
                                st.addRow("" + requestSql.get_post().get(0).get(i),
                                        "" + requestSql.get_post().get(1).get(i));
                            }
                            st.print();
                            break;
                        }
                        default:{
                            System.out.println("Эта команда не поддерживается для данной таблицы или такой таблицы не существует");
                        }
                        break;
                    }
                    break;
                }
                case "add": {
                    if(cmd_line.countTokens() == 0){
                        System.out.println("Не задано имя таблицы");
                        continue;
                    }
                    switch (cmd_line.nextToken().toLowerCase()) {
                        case "department" : {
                            System.out.println("Введите address, balance, region_id: ");
                            try {
                                String address = input.nextLine();
                                int balance = Integer.parseInt(input.nextLine());
                                int region_id = Integer.parseInt(input.nextLine());
                                requestSql.add_department(address, balance, region_id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "account" : {
                            System.out.println("Введите number, balance: ");
                            try {
                                int number = Integer.parseInt(input.nextLine());
                                int balance = Integer.parseInt(input.nextLine());
                                requestSql.add_account(number, balance);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "additional_services" : {
                            System.out.println("Введите cost, name: ");
                            try {
                                int cost = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                requestSql.add_additional_services(cost, name);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "atm" : {
                            System.out.println("Введите department_id, balance: ");
                            try {
                                int department_id = Integer.parseInt(input.nextLine());
                                int balance = Integer.parseInt(input.nextLine());
                                Timestamp date_of_maintenance = new Timestamp(System.currentTimeMillis());
                                requestSql.add_atm(department_id, balance, date_of_maintenance);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "region" : {
                            System.out.println("Введите name: ");
                            try {
                                String name = input.nextLine();
                                requestSql.add_region(name);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "client_services" : {
                            System.out.println("Введите client_id, service_id: ");
                            try {
                                int client_id = Integer.parseInt(input.nextLine());
                                int service_id = Integer.parseInt(input.nextLine());
                                requestSql.add_client_service(client_id, service_id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "client" : {
                            System.out.println("Введите region_id, name, account_number: ");
                            try {
                                int region_id = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                int account_number = Integer.parseInt(input.nextLine());
                                requestSql.add_client(region_id, name, account_number);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "employee" : {
                            System.out.println("Введите post_id, name, salary, department_id: ");
                            try {
                                int post_id = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                int salary = Integer.parseInt(input.nextLine());
                                int department_id = Integer.parseInt(input.nextLine());
                                requestSql.add_employee(post_id, name, salary, department_id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "post" : {
                            System.out.println("Введите name: ");
                            try {
                                String name = input.nextLine();
                                requestSql.add_post(name);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }

                        default:{
                            System.out.println("Эта команда не поддерживается для данной таблицы или такой таблицы не существует");
                        }
                        break;
                    }
                    break;
                }
                case "delete": {
                    if(cmd_line.countTokens() == 0){
                        System.out.println("Не задано имя таблицы");
                        continue;
                    }
                    switch (cmd_line.nextToken().toLowerCase()) {
                        case "department" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_department(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "account" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_account(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "additional_services" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_additional_services(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "atm" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_atm(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "region" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_region(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "client_services" : {
                            System.out.println("Введите client_id, service_id: ");
                            try {
                                int client_id = Integer.parseInt(input.nextLine());
                                int service_id = Integer.parseInt(input.nextLine());
                                requestSql.delete_client_services(client_id, service_id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "client" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_client(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "employee" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_employee(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "post" : {
                            System.out.println("Введите id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                requestSql.delete_post(id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }

                        default:{
                            System.out.println("Эта команда не поддерживается для данной таблицы или такой таблицы не существует");
                        }
                        break;
                    }
                    break;
                }
                case "update": {
                    if(cmd_line.countTokens() == 0){
                        System.out.println("Не задано имя таблицы");
                        continue;
                    }
                    switch (cmd_line.nextToken().toLowerCase()) {
                        case "department" : {
                            System.out.println("Введите id, address, balance, region_id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                String address = input.nextLine();
                                int balance = Integer.parseInt(input.nextLine());
                                int region_id = Integer.parseInt(input.nextLine());
                                requestSql.update_department(id, address, balance, region_id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "account" : {
                            System.out.println("Введите number, balance: ");
                            try {
                                int number = Integer.parseInt(input.nextLine());
                                int balance = Integer.parseInt(input.nextLine());
                                requestSql.update_account(number, balance);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "additional_services" : {
                            System.out.println("Введите id, cost, name: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                int cost = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                requestSql.update_additional_services(id, cost, name);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "atm" : {
                            System.out.println("Введите department_id, balance: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                int department_id = Integer.parseInt(input.nextLine());
                                int balance = Integer.parseInt(input.nextLine());
                                Timestamp date_of_maintenance = new Timestamp(System.currentTimeMillis());
                                requestSql.update_atm(id, department_id, balance, date_of_maintenance);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "region" : {
                            System.out.println("Введите id, name: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                requestSql.update_region(id, name);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "client_services" : {
                            System.out.println("Введите client_id_old, service_id_old, client_id_new, service_id_new: ");
                            try {
                                int client_id_old = Integer.parseInt(input.nextLine());
                                int service_id_old = Integer.parseInt(input.nextLine());
                                int client_id_new = Integer.parseInt(input.nextLine());
                                int service_id_new = Integer.parseInt(input.nextLine());
                                requestSql.update_client_services(client_id_old, service_id_old, client_id_new, service_id_new);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "client" : {
                            System.out.println("Введите id, region_id, name, account_number: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                int region_id = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                int account_number = Integer.parseInt(input.nextLine());
                                requestSql.update_client(id, region_id, name, account_number);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "employee" : {
                            System.out.println("Введите id, post_id, name, salary, department_id: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                int post_id = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                int salary = Integer.parseInt(input.nextLine());
                                int department_id = Integer.parseInt(input.nextLine());
                                requestSql.update_employee(id, post_id, name, salary, department_id);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }
                        case "post" : {
                            System.out.println("Введите id, name: ");
                            try {
                                int id = Integer.parseInt(input.nextLine());
                                String name = input.nextLine();
                                requestSql.update_post(id, name);
                            }
                            catch (Exception e){
                                System.out.println("Ошибка ввода");
                            }
                            break;
                        }

                        default:{
                            System.out.println("Эта команда не поддерживается для данной таблицы или такой таблицы не существует");
                        }
                        break;
                    }
                    break;
                }
                case "help": {
                    DispHelp();
                    break;
                }
                case "exit":
                    cont = false;
                    break;
                default:
                    System.out.println("Unknown command");
                    DispHelp();
                    break;
            }
        }
    }

    private static void DispHelp() {
        System.out.println("list                 - Список таблиц");
        System.out.println("show <имя таблицы>   - Вывод таблицы");
        System.out.println("add <имя таблицы>    - Новая запись");
        System.out.println("update <имя таблицы> - Изменить запись");
        System.out.println("delete <имя таблицы> - Удалить запись");
        System.out.println("help - Справка");
        System.out.println("exit - Выход");
    }

}