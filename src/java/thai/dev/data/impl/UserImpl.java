    package thai.dev.data.impl;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;

    import thai.dev.data.dao.UserDAO;
    import thai.dev.data.driver.MySQLDriver;
    import thai.dev.data.model.User;

    public class UserImpl implements UserDAO {

    //    private Connection con;
        Connection con = MySQLDriver.getInstance().getConnection();

        // Constructor to initialize connection
        public UserImpl() {
            this.con = MySQLDriver.getInstance().getConnection();
        }

        @Override
        public boolean insert(User user) {
            String sql = "INSERT INTO `USER` (EMAIL, PASSWORD, ROLE) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getRole());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public boolean update(User user) {
            String sql = "UPDATE `USER` SET EMAIL = ?, PASSWORD = ?, ROLE = ? WHERE ID = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getRole());
                stmt.setInt(4, user.getId());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public boolean delete(int id) {
            String sql = "DELETE FROM `USER` WHERE ID = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public User find(int id) {
            String sql = "SELECT * FROM `USER` WHERE ID = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String email = rs.getString("email");
                        String password = rs.getString("password");
                        String role = rs.getString("role");
                        return new User(id, email, password, role);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public List<User> findAll() {
            List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM `USER`";
            try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    users.add(new User(id, email, password, role));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return users;
        }

        @Override
        public User find(String email, String password) {
            String sql = "SELECT * FROM `USER` WHERE EMAIL = ? AND PASSWORD = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        String role = rs.getString("role");
                        return new User(id, email, password, role);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public User find(String email) {
            String sql = "SELECT * FROM `USER` WHERE EMAIL = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        String password = rs.getString("password");
                        String role = rs.getString("role");
                        return new User(id, email, password, role);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
