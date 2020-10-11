import java.sql.*;
import java.util.ArrayList;

class requestSql {
    //Настройки подключения к базе данных
    static String url = "jdbc:postgresql://localhost:5432/bank";
    static String login = "postgres";
    static String password = "admin";

    static ArrayList<String> get_tables(){
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("table_name"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        return result;
    }

    static ArrayList<ArrayList> get_departments() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> address = new ArrayList<>();
        ArrayList<String> balance = new ArrayList<>();
        ArrayList<String> region = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT d.id, d.address, d.balance, r.name as region\n" +
                    "FROM public.department d \n" +
                    "INNER JOIN public.region r ON d.region_id = r.id;";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                address.add(rs.getString("address"));
                balance.add(rs.getString("balance"));
                region.add(rs.getString("region"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(address);
        array.add(balance);
        array.add(region);
        return array;
    }

    static ArrayList<ArrayList> get_account() {
        ArrayList<String> number = new ArrayList<>();
        ArrayList<String> balance = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT \"number\", balance\n" +
                    "FROM public.account;\n";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                balance.add(rs.getString("balance"));
                number.add(rs.getString("number"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(number);
        array.add(balance);
        return array;
    }

    static ArrayList<ArrayList> get_atm() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> balance = new ArrayList<>();
        ArrayList<String> department = new ArrayList<>();
        ArrayList<Timestamp> date_of_maintenance = new ArrayList<>();


        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT a.id, d.address, a.balance, a.date_of_maintenance\n" +
                    "FROM public.atm a\n" +
                    "INNER JOIN public.department d on a.department_id = d.id;";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                balance.add(rs.getString("balance"));
                department.add(rs.getString("address"));
                date_of_maintenance.add(rs.getTimestamp("date_of_maintenance"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(balance);
        array.add(department);
        array.add(date_of_maintenance);
        return array;
    }

    static ArrayList<ArrayList> get_additional_services() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> cost = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT id, \"name\", \"cost\"\n" +
                    "FROM public.additional_services;\n";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                cost.add(rs.getString("cost"));
                name.add(rs.getString("name"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(cost);
        array.add(name);
        return array;
    }

    static ArrayList<ArrayList> get_region() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT id, \"name\"\n" +
                    "FROM public.region;\n";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                name.add(rs.getString("name"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(name);
        return array;
    }
    static ArrayList<ArrayList> get_post() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT id, \"name\"\n" +
                    "FROM public.post;\n";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                name.add(rs.getString("name"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(name);
        return array;
    }
    static ArrayList<ArrayList> get_client() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();
        ArrayList<String> balance = new ArrayList<>();
        ArrayList<String> region = new ArrayList<>();
//        ArrayList<String> cost = new ArrayList<>();
        ArrayList<String> service = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT c.id, c.name,  a.number, a.balance, r.name as region, array_agg(a_s.cost) as cost,  array_agg(a_s.name) as service\n" +
                    "FROM public.client c\n" +
                    "INNER JOIN public.account a ON c.account_number = a.number\n" +
                    "INNER JOIN public.region r ON r.id = c.region_id\n" +
                    "INNER JOIN public.client_services cs ON cs.client_id = c.id\n" +
                    "INNER JOIN public.additional_services a_s ON a_s.id = cs.service_id\n" +
                    "GROUP BY c.id, c.name, a.number, a.balance, r.name";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                name.add(rs.getString("name"));
                number.add(rs.getString("number"));
                balance.add(rs.getString("balance"));
                region.add(rs.getString("region"));
//                cost.add(rs.getString("cost"));
                service.add(rs.getString("service"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(name);
        array.add(number);
        array.add(balance);
        array.add(region);
//        array.add(cost);
        array.add(service);
        return array;
    }

    static ArrayList<ArrayList> get_employee() {
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> post = new ArrayList<>();
        ArrayList<String> salary = new ArrayList<>();
        ArrayList<String> address = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String sql = "SELECT e.id, e.name, e.salary, p.name AS post, d.address\n" +
                    "FROM public.employee e\n" +
                    "INNER JOIN public.post p ON e.post_id = p.id\n" +
                    "INNER JOIN public.department d ON d.id = e.department_id;";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                id.add(rs.getString("id"));
                name.add(rs.getString("name"));
                post.add(rs.getString("post"));
                salary.add(rs.getString("salary"));
                address.add(rs.getString("address"));
            }
            rs.close();
            prepSt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("- ? -" + ex);
        }
        ArrayList<ArrayList> array = new ArrayList<>();
        array.add(id);
        array.add(name);
        array.add(post);
        array.add(salary);
        array.add(address);
        return array;
    }

    static void add_additional_services(int cost, String name) {
        String sql = "INSERT INTO public.additional_services (cost, name) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1,cost);
            prepSt.setString(2, name);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_atm(int department_id, int balance, Timestamp date_of_maintenance) {
        String sql = "INSERT INTO public.atm (department_id, balance, date_of_maintenance) VALUES (?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1,department_id);
            prepSt.setInt(2, balance);
            prepSt.setTimestamp(3, date_of_maintenance);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_department(String address, int balance, int region_id) {
        String sql = "INSERT INTO public.department (address, balance, region_id) VALUES (?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, address);
            prepSt.setInt(2, balance);
            prepSt.setInt(3, region_id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_region(String name) {
        String sql = "INSERT INTO public.region (name) VALUES (?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, name);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_client_service(int client_id, int service_id) {
        String sql = "INSERT INTO public.client_services (client_id, service_id) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, client_id);
            prepSt.setInt(2, service_id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_client(int region_id, String name, int account_number) {
        String sql = "INSERT INTO public.client (region_id, name, account_number) VALUES (?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, region_id);
            prepSt.setString(2, name);
            prepSt.setInt(3, account_number);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
            
        }
        System.out.println("Inserted!");
    }

    static void add_employee(int post_id, String name, int salary, int department_id) {
        String sql = "INSERT INTO public.employee (post_id, name, salary, department_id) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, post_id);
            prepSt.setString(2, name);
            prepSt.setInt(3, salary);
            prepSt.setInt(4, department_id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_post(String name) {
        String sql = "INSERT INTO public.post (name) VALUES (?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, name);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void add_account(int number, int balance) {
        String sql = "INSERT INTO public.account (number, balance) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, number);
            prepSt.setInt(2, balance);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Inserted!");
    }

    static void delete_additional_services(int id) {
        String sql = "DELETE FROM public.additional_services WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    static void delete_atm(int id) {
        String sql = "DELETE FROM public.atm WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    static void delete_department(int id) {
        String sql = "DELETE FROM public.department WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    static void delete_region(int id) {
        String sql = "DELETE FROM public.region WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    static void delete_client_services(int client_id, int service_id) {
        String sql = "DELETE FROM public.client_services WHERE client_id = ? AND service_id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, client_id);
            prepSt.setInt(2, service_id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
        System.out.println("Deleted!");
    }

    static void delete_client(int id) {
        String sql = "DELETE FROM public.client WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    static void delete_employee(int id) {
        String sql = "DELETE FROM public.employee WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    static void delete_post(int id) {
        String sql = "DELETE FROM public.post WHERE id = ?";
        delete(id, sql);
        System.out.println("Deleted!");
    }

    private static void delete(int id, String sql) {
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    static void delete_account(int number) {
        String sql = "DELETE FROM public.account WHERE number = ?";
        delete(number, sql);
    }

    static void update_additional_services(int id, int cost, String name) {
        String sql = "UPDATE public.additional_services SET cost = ?, name = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, cost);
            prepSt.setString(2, name);
            prepSt.setInt(3, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_atm(int id, int department_id, int balance, Timestamp date_of_maintenance) {
        String sql = "UPDATE public.atm SET department_id = ?, balance = ?, date_of_maintenance = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, department_id);
            prepSt.setInt(2, balance);
            prepSt.setTimestamp(3, date_of_maintenance);
            prepSt.setInt(4, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_department(int id, String address, int balance, int region_id) {
        String sql = "UPDATE public.department SET address = ?, balance = ?, region_id = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, address);
            prepSt.setInt(2, balance);
            prepSt.setInt(3, region_id);
            prepSt.setInt(4, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_region(int id, String name) {
        String sql = "UPDATE public.region SET name = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, name);
            prepSt.setInt(2, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_client_services(int client_id_old, int service_id_old, int client_id_new, int service_id_new) {
        String sql = "UPDATE public.client_services SET client_id = ?, service_id = ? WHERE client_id = ? AND service_id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, client_id_new);
            prepSt.setInt(2, service_id_new);
            prepSt.setInt(3, client_id_old);
            prepSt.setInt(4, service_id_old);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_client(int id, int region_id, String name, int account_number) {
        String sql = "UPDATE public.client SET region_id = ?, name = ? , account_number = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, region_id);
            prepSt.setString(2, name);
            prepSt.setInt(3, account_number);
            prepSt.setInt(4, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_employee(int id, int post_id, String name, int salary, int department_id) {
        String sql = "UPDATE public.employee SET post_id = ?, name = ?, salary = ?, department_id WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, post_id);
            prepSt.setString(2, name);
            prepSt.setInt(3, salary);
            prepSt.setInt(4, department_id);
            prepSt.setInt(5, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_post(int id, String name) {
        String sql = "UPDATE public.post SET name = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, name);
            prepSt.setInt(2, id);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }

    static void update_account(int number, int balance) {
        String sql = "UPDATE public.account SET balance = ? WHERE number = ?";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, balance);
            prepSt.setInt(2, number);
            prepSt.executeUpdate();
            prepSt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Updated!");
    }
}
