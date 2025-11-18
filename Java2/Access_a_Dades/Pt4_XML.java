import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class Pt4_XML {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- GESTIÓN DEL ZOO ---");
        System.out.println("1. Crear archivo XML (DOM)");
        System.out.println("2. Leer archivo XML (SAX)");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar sacnner

        if (opcion == 1) {
            crearXML();
        } else if (opcion == 2) {
            leerXML();
        } else {
            System.out.println("Opción no válida.");
        }

        sc.close();
    }

    // Parte 1 - Crear XML (DOM)
    public static void crearXML() {
        try {
            // Crear el documento XML en memoria
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Crear el elemento raíz <zoo>
            Element root = doc.createElement("zoo");
            doc.appendChild(root);

            // Agregar algunos animales
            root.appendChild(crearAnimal(doc, 1, "Pingüino", "Aptenodytes forsteri", "Pescado", 6));
            root.appendChild(crearAnimal(doc, 2, "León", "Panthera leo", "Carne", 7));
            root.appendChild(crearAnimal(doc, 3, "Gorilla", "Gorilla Gorilla Gorilla", "Verduras", 12));

            // Guardar el documento en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("zoo.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo zoo.xml creado correctamente.");
        } catch (ParserConfigurationException | TransformerException | DOMException e) {
            System.out.println("Error creando el XML:");
        }
    }

    // Método para crear animal
    private static Element crearAnimal(Document doc, int id, String nombre, String especie, String alimento, int edad) {
        Element animal = doc.createElement("animal");
        animal.setAttribute("id", String.valueOf(id));

        Element nombreEl = doc.createElement("nom");
        nombreEl.setTextContent(nombre);
        animal.appendChild(nombreEl);

        Element especieEl = doc.createElement("especie");
        especieEl.setTextContent(especie);
        animal.appendChild(especieEl);

        Element alimentoEl = doc.createElement("aliment");
        alimentoEl.setTextContent(alimento);
        animal.appendChild(alimentoEl);

        Element edadEl = doc.createElement("edat");
        edadEl.setTextContent(String.valueOf(edad));
        animal.appendChild(edadEl);

        return animal;
    }

    // Parte 2 - Leer XML (SAX)
    public static void leerXML() {
        try {
            File xmlFile = new File("zoo.xml");
            if (!xmlFile.exists()) {
                System.out.println("El archivo zoo.xml no existe. Crea el archivo primero ");
                return;
            }

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bNombre = false, bEspecie = false, bAlimento = false, bEdad = false;
                int currentId = 0;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    switch (qName.toLowerCase()) {
                        case "animal":
                            currentId = Integer.parseInt(attributes.getValue("id"));
                            System.out.println("\nAnimal #" + currentId);
                            break;
                        case "nom":
                            bNombre = true;
                            break;
                        case "especie":
                            bEspecie = true;
                            break;
                        case "aliment":
                            bAlimento = true;
                            break;
                        case "edat":
                            bEdad = true;
                            break;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String texto = new String(ch, start, length).trim();
                    if (texto.isEmpty()) return;

                    if (bNombre) {
                        System.out.println("Nombre: " + texto);
                        bNombre = false;
                    } else if (bEspecie) {
                        System.out.println("Especie: " + texto);
                        bEspecie = false;
                    } else if (bAlimento) {
                        System.out.println("Alimento: " + texto);
                        bAlimento = false;
                    } else if (bEdad) {
                        System.out.println("Edad: " + texto);
                        bEdad = false;
                    }
                }
            };

            saxParser.parse(xmlFile, handler);
            System.out.println("\nLectura completada correctamente.");

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error leyendo el XML:");
        }
    }
}
