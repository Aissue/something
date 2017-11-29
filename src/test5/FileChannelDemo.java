package test5;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Administrator on 2017/11/28.
 * FileChannel的测试类
 */
public class FileChannelDemo {

    @Test
    public void test1(){
        try {
            /**
             * 1、获取Channel的一种方式
             */
            //FileChannel inChannel = FileChannel.open(Paths.get("src/test5/a.txt"), StandardOpenOption.READ);
            //FileChannel outChannel = FileChannel.open(Paths.get("src/test5/b.txt"),StandardOpenOption.WRITE);

            /**
             * 2、获取Channel的另一种方式
             * 通过这种方式可以实现文本追加
             */
            FileInputStream fis = new FileInputStream("src/test5/a.txt");
            FileChannel inChannel = fis.getChannel();
            FileOutputStream fos = new FileOutputStream("src/test5/b.txt",true);
            FileChannel outChannel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(24);
            /**
             * Reads a sequence of bytes from this channel into the given buffer.
             * 从通道读取到缓冲区中，读取的字节数量是n (n是buffer中当前剩余的容量)
             */
            int bytesRead = inChannel.read(buf);
            System.out.println(buf.position());
            int loop = 1;
            while (bytesRead !=-1){
                buf.flip();//将buffer由写读模式切换为写模式
                while(buf.hasRemaining()){
                    //System.out.println((char) buf.get());
                    outChannel.write(buf);
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
                loop++;
            }
            System.out.println(loop);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
