import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

public class App {
    static File f;

    public static void main(String[] args) throws Exception {
        // default value
        boolean looping = true;
        Path file_path = null;

        // changes value
        Menu _menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int choices = -1;

        List_Control _list_control = new List_Control();

        try {
            pop_up();
            if (accept(f)) {
                file_path = Paths.get(f.getPath());
                if (_list_control.read_data(file_path.toString()) == true) {
                    System.out.println("Import successfully");
                }
            } else
                System.out.println("Invalid file!!");
        } catch (Exception e) {
        }

        while (looping) {
            _menu.main_menu();
            try {
                choices = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                choices = -1;
                sc.nextLine();
            }
            switch (choices) {
                case 1: {
                    int something = _list_control.choices_add_data();
                    if (something == 1) {
                        boolean inner_loop = true;
                        while (inner_loop) {
                            if (pop_up()) {
                                if (accept(f)) {
                                    _list_control.remove_all();
                                    file_path = Paths.get(f.getPath());
                                    if (_list_control.read_data(file_path.toString()) == true) {
                                        System.out.println("Import successfully");
                                    }
                                    inner_loop = false;
                                } else
                                    System.out.println("Invalid file!!");
                            } else
                                break;
                        }
                    } else if (something == 2) {
                        boolean inner_loop = true;
                        while (inner_loop) {
                            if (pop_up()) {
                                if (accept(f)) {
                                    file_path = Paths.get(f.getPath());
                                    if (_list_control.read_data(file_path.toString()) == true) {
                                        System.out.println("Import successfully");
                                    }
                                    inner_loop = false;
                                } else
                                    System.out.println("Invalid file!!");
                            } else
                                break;
                        }
                    } else
                        break;
                    break;
                }

                case 2: {
                    if (_list_control.return_size() == 0) {
                        System.out.println("This list is empty!");
                    } else {
                        ArrayList<Integer> _temp = new ArrayList<Integer>();
                        System.out.print("Enter value: ");
                        String value = sc.nextLine().trim();
                        _temp = _list_control.find_data(value);
                        if (_temp != null) {
                            for (Integer i : _temp) {
                                System.out.println("index: " + i);
                                _list_control.get(i).output_map();
                            }
                        } else
                            System.out.println("Not found!");
                    }
                    break;
                }

                case 3: {
                    boolean flag = _list_control.add_data();
                    if (flag)
                        System.out.println("Insert successfully!");
                    else
                        System.out.println("Insert failed!");
                    break;
                }

                case 4: {
                    if (_list_control.return_size() == 0)
                        System.out.println("This list is empty!");
                    else {
                        ArrayList<Integer> _temp = new ArrayList<Integer>();
                        System.out.print("Enter value: ");
                        String value = sc.nextLine().trim();
                        _temp = _list_control.find_data(value);
                        if (_temp != null) {
                            for (Integer i : _temp) {
                                System.out.println("index: " + i);
                                _list_control.get(i).output_map();
                            }
                            try {
                                System.out.print("index: ");
                                int select = sc.nextInt();
                                sc.nextLine();
                                if (_list_control.get(select) != null)
                                    _list_control.update_data(select);
                            } catch (Exception e) {
                                sc.nextLine();
                                System.out.println("Invalid input!");
                            }
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break;
                }

                case 5: {
                    if (_list_control.return_size() == 0)
                        System.out.println("This list is empty!");
                    else {
                        boolean flag = false;
                        ArrayList<Integer> _temp = new ArrayList<Integer>();
                        System.out.print("Enter value: ");
                        String value = sc.nextLine();
                        _temp = _list_control.find_data(value);
                        if (_temp != null) {
                            for (Integer i : _temp) {
                                System.out.println("index: " + i);
                                _list_control.get(i).output_map();
                            }
                            try {
                                System.out.print("index: ");
                                int select = sc.nextInt();
                                sc.nextLine();
                                flag = _list_control.remove_data(select);
                            } catch (Exception e) {
                                sc.nextLine();
                                System.out.println("Invalid input!");
                            }
                            if (flag == true)
                                System.out.println("Remove successfully");
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break;
                }

                case 6: {
                    if (_list_control.return_size() == 0) {
                        System.out.println("This list is empty!");
                    } else
                        _list_control.export_data();
                    break;
                }

                case 7: {
                    looping = false;
                    break;
                }

                case 99: {
                    for (Candidate _Candidate : _list_control._list) {
                        _Candidate.output_map();
                    }
                    break;
                }

                default: {
                    System.out.println("Invalid option!");
                    break;
                }
            }
        }
    }

    static boolean pop_up() {
        String home_dir = System.getProperty("user.dir");
        JFileChooser f_cFileChooser = new JFileChooser(home_dir + "\\src");
        int option = f_cFileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            f = f_cFileChooser.getSelectedFile();
            return true;
        }
        return false;
    }

    static boolean accept(File filename) {
        if (filename.getName().toLowerCase().endsWith(".txt"))
            return true;
        return false;
    }
}
