package jm233333.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import jm233333.Director;
import jm233333.visualized.VisualizedDataStructure;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * The {@code SceneMenu} class maintains a scene graph for the main menu of the application.
 * Extended from JavaFX class {@code Scene}.
 */
public class SceneMenu extends Scene {

    private FlowPane root;
    private ScrollBar scrollBar;

    /**
     * Creates a SceneMenu with a specific size.
     *
     * @param root The root node of the scene graph
     * @param width The width of the scene
     * @param height The height of the scene
     */
    public SceneMenu(FlowPane root, double width, double height) {
        super(root, width, height, Color.WHITE);
        this.root = root;
        initialize();
    }

    /**
     * Initializes the SceneMenu.
     */
    private void initialize() {
        scrollBar = new ScrollBar();
        root.getChildren().add(scrollBar);
        initializeList();
    }
    private void initializeList() {
//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("custom/ui/menu.txt"));
        } catch (FileNotFoundException e) {
            in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/default/ui/menu.txt")));
        }
        try {
            while (in.ready()) {
                String[] args = in.readLine().split(" ");
                assert (args.length > 0);
                addButton(args);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addButton(String... args) {
        // get class data
        String dsName = args[0];
        String className = "Visualized" + dsName;
        int argc = args.length - 1;
        Class<?>[] parameterTypes = new Class<?>[argc];
        Object[] arguments = new Object[argc];
        for (int i = 0; i < argc; i ++) {
            parameterTypes[i] = int.class;
            arguments[i] = Integer.parseInt(args[i + 1]);
        }
        // get class type of the visualized data structure
        Class<?> classType;
        try {
            classType = Class.forName("jm233333.visualized." + className);
        } catch (ClassNotFoundException ex) {
            try {
                root.getChildren().add(new Label("GG"));
//                if (!new File("./custom/visualized/" + className + ".java").exists()) {
//                    throw new IOException();
//                }
                JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
                int status = javac.run(null, null, null,
                        "-d",
                        this.getClass().getResource("/").getPath(),
                        "custom/visualized/" + className + ".java"
                );
                classType = Class.forName("jm233333.visualized." + className);
                root.getChildren().add(new Label(classType.getName()));
                return;
            } catch (ClassNotFoundException e) {
                root.getChildren().add(new Label(e.getClass().getName()));
                return;
            }

        }
        // initialize buttons linked to corresponding SceneVisualizer
        try {
            // get needed constructor
            //Class<?>[] parameterTypes = {int.class};
            //Object[] parameters = {10};
            Constructor constructor = classType.getConstructor(parameterTypes);
            // create a new instance
            final VisualizedDataStructure visualDS = (VisualizedDataStructure)constructor.newInstance(arguments);
            visualDS.setName(dsName);
            // initialize button
            String name = className + " " + Arrays.toString(arguments);
            Button button = new Button(name);
            root.getChildren().add(button);
            // set listener
            button.setOnAction((event) -> {
                Scene scene = new SceneVisualizer(new BorderPane(), visualDS);
                Director.getInstance().getPrimaryStage().setScene(scene);
            });
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
