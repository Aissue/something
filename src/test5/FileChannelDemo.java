package test5;

import org.junit.Test;

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
            FileChannel inChannel = FileChannel.open(Paths.get("src/test5/a.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("src/test5/b.txt"),StandardOpenOption.WRITE);
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
