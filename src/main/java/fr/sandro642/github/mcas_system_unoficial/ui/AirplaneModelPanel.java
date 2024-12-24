package fr.sandro642.github.mcas_system_unoficial.ui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

import javax.swing.*;
import java.io.File;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.system.JmeSystem;
import com.jme3.scene.Spatial;
import com.jme3.scene.plugins.gltf.GltfLoader;

public class AirplaneModelPanel extends JPanel {

    public AirplaneModelPanel() {
        Platform.runLater(this::initialize);
    }

    private void initialize() {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, true, SceneAntialiasing.BALANCED);

        // Add a camera model to render the scene in perspective
        PerspectiveCamera camera = new PerspectiveCamera(true);
        scene.setCamera(camera);

        // Load the 3D model of the airplane
        loadAirplaneModel(root);

        // Adjust the camera position
        camera.setTranslateZ(-1000);
        camera.setTranslateY(-200);
        camera.setTranslateX(100);

        // Attach the scene to JFXPanel
        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setScene(scene);
        add(jfxPanel);
    }

    // Method to load the 3D model
    private void loadAirplaneModel(Group root) {
        String modelPath = "assets/airplane_model.glb";
        File modelFile = new File(modelPath);

        if (!modelFile.exists()) {
            System.out.println("Model file not found!");
            return;
        }

        try {
            Spatial airplane = loadGLBModel(modelFile);
            // Convert the jMonkeyEngine model to a JavaFX node
            Node airplaneNode = convertToJavaFXNode(airplane);
            airplaneNode.setTranslateX(400);
            airplaneNode.setTranslateY(300);

            root.getChildren().add(airplaneNode);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load the model.");
        }
    }

    // Load the .glb model
    private Spatial loadGLBModel(File modelFile) {
        try {
            AssetManager assetManager = JmeSystem.newAssetManager(Thread.currentThread().getContextClassLoader().getResource("com/jme3/asset/Desktop.cfg"));
            assetManager.registerLocator(modelFile.getParent(), FileLocator.class);
            GltfLoader loader = new GltfLoader();
            assetManager.registerLoader(GltfLoader.class, "glb");
            return assetManager.loadModel(modelFile.getName());
        } catch (Exception e) {
            System.out.println("Error loading GLB model: " + e.getMessage());
            return null;
        }
    }

    // Convert jMonkeyEngine Spatial to JavaFX Node
    private Node convertToJavaFXNode(Spatial spatial) {
        // This is a placeholder implementation. You need to implement the actual conversion logic.
        Sphere sphere = new Sphere(50);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.RED);
        sphere.setMaterial(material);
        return sphere;
    }
}