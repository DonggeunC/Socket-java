����   7 �  kcci/iot/cdg_v1/ServerCdgThread  java/lang/Thread 
queueInput $Ljava/util/concurrent/BlockingQueue; 	Signature 8Ljava/util/concurrent/BlockingQueue<Ljava/lang/String;>; socket Ljava/net/Socket; <clinit> ()V Code  (java/util/concurrent/LinkedBlockingQueue
     <init>	     LineNumberTable LocalVariableTable
  	   	 
 this !Lkcci/iot/cdg_v1/ServerCdgThread; run   kcci/iot/cdg_v1/ClientCdgExample
   ! java/net/ServerSocket
    $ java/net/InetSocketAddress & 	localhost
 # (  ) (Ljava/lang/String;I)V
   + , - bind (Ljava/net/SocketAddress;)V	 / 1 0 java/lang/System 2 3 out Ljava/io/PrintStream; 5 [연결 기다림]
 7 9 8 java/io/PrintStream : ; println (Ljava/lang/String;)V
   = > ? accept ()Ljava/net/Socket;
 A C B java/net/Socket D E getRemoteSocketAddress ()Ljava/net/SocketAddress; G java/lang/StringBuilder I [연결 수락함]
 F K  ;
 # M N O getHostName ()Ljava/lang/String;
 F Q R S append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 F U V O toString
 A X Y Z getInputStream ()Ljava/io/InputStream;
 \ ^ ] java/io/InputStream _ ` read ([B)I b java/lang/String d UTF-8
 a f  g ([BIILjava/lang/String;)V i quit
 a k l m equals (Ljava/lang/Object;)Z
  o p ; sendData r [데이터 받기 성공]
   t u v isClosed ()Z
   x y  close { java/lang/Exception } java/io/IOException Cdg "Lkcci/iot/cdg_v1/ClientCdgExample; serverSocket Ljava/net/ServerSocket; isa Ljava/net/InetSocketAddress; state I isa1 bytes [B message Ljava/lang/String; is Ljava/io/InputStream; readByteCount e Ljava/lang/Exception; StackMapTable � � � � "java/util/concurrent/BlockingQueue � m offer
 A � � � getOutputStream ()Ljava/io/OutputStream;
 a � � � getBytes (Ljava/lang/String;)[B
 � � � java/io/OutputStream � � write ([B)V
 � � �  flush � [데이터 보내기 성공]
 z � �  printStackTrace os Ljava/io/OutputStream; 
SourceFile ServerCdgThread.java !                 	 
           +      � Y� � �                         <     
*� *� �              	         
           �  	  � Y� LM�  Y� "M,� #Y%�� '� *� .4� 6*,� <� *� � @� #N� .� FYH� J-� L� P� T� 66� <� .4� 66*,� <� *� � @� #:� .� FYH� J� L� P� T� 6::*� � W:d�:� [6� � T� aYc� e:h� j� 	6��~*� n� .� FYq� J� P� T� 6��^N,� s� ,� w� :�  
 � � z
 |     � %      
    "  *  2  9  =  V  Y ( _ ) g * j + r - y , ~ . � 0 � 1 � 2 � 3 � 4 � 5 � 6 � 7 � 8 � 9 � : � < � = �   � B � C E
 F G J    p         ~   
 � �  = � � �  Y � � �  ~  � �  � ` � �  � ] � �  � T � �  � E � �  �  � �  �   b � Y      #  >� % 	     # � a \  �        z�       z  |�    p ;     �     A� +� � W*� � �M+c� �N,-� �,� �� .� FY�� J+� P� T� 6� M,� ��  
 8 ; z     & 	   L 
 N  O  P  Q " R 8 S < T @ V    4    A       A � �   & � �    � �  <  � �  �    { z  �    �