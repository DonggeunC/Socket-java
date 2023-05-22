����   7 h   kcci/iot/cdg_v1/ClientCdgExample  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this "Lkcci/iot/cdg_v1/ClientCdgExample; main ([Ljava/lang/String;)V 
Exceptions  java/lang/Exception  kcci/iot/cdg_v1/ClientCdgThread
  	  java/net/Socket
  		     socket Ljava/net/Socket;	     java/lang/System ! " out Ljava/io/PrintStream; $ [연결 요청]
 & ( ' java/io/PrintStream ) * println (Ljava/lang/String;)V , java/net/InetSocketAddress . 	localhost
 + 0  1 (Ljava/lang/String;I)V
  3 4 5 connect (Ljava/net/SocketAddress;)V 7 [연결 성공]
  9 :  start < java/util/Scanner	  > ? @ in Ljava/io/InputStream;
 ; B  C (Ljava/io/InputStream;)V
 ; E F G nextLine ()Ljava/lang/String;
  I J K sendData &(Ljava/lang/String;Ljava/net/Socket;)V M quit
 O Q P java/lang/String R S equals (Ljava/lang/Object;)Z U )클라이언트가 종료되었습니다.
  W X Y 
stopClient (Ljava/net/Socket;)V [ java/io/IOException args [Ljava/lang/String; clientCdgThread !Lkcci/iot/cdg_v1/ClientCdgThread; scan Ljava/util/Scanner; message Ljava/lang/String; StackMapTable ] 
SourceFile ClientCdgExample.java !               /     *� �    
                    	                 q� Y� L+� Y� � � #� %+� � +Y-�� /� 2� 6� %� M+� 8� ;Y� =� AM,� DN+-+� � H-L� N��� T� %++� � V�   6 9 Z  
   >           .  6  9  :  >   I ! N " W # ` $ h % p )    *    q \ ]    i ^ _  I ' ` a  N " b c  d    � 9  e   Z   f    g