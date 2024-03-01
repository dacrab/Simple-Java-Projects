import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class FileEncryptionDecryptionTool {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Encryption/Decryption Tool");

        System.out.print("Enter path of the file: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter encryption (E) or decryption (D) mode: ");
        char mode = scanner.nextLine().toUpperCase().charAt(0);

        System.out.print("Enter secret key: ");
        String secretKey = scanner.nextLine();

        try {
            if (mode == 'E') {
                encryptFile(filePath, secretKey);
                System.out.println("File encrypted successfully!");
            } else if (mode == 'D') {
                decryptFile(filePath, secretKey);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid mode! Please enter 'E' for encryption or 'D' for decryption.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void encryptFile(String filePath, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), ALGORITHM));

        processFile(filePath, cipher);
    }

    private static void decryptFile(String filePath, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), ALGORITHM));

        processFile(filePath, cipher);
    }

    private static void processFile(String filePath, Cipher cipher) throws IOException, IllegalBlockSizeException, BadPaddingException {
        FileInputStream inputStream = new FileInputStream(filePath);
        byte[] inputBytes = new byte[(int) new File(filePath).length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }
}
