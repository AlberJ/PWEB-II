Roteiro da implementação
========================

Índice:
1. Baixa o projeto do BitBucket, Tag 'Inicial'
2. Definir um template
3. Implementar tela de login com bootstrap


1. Baixa o projeto do BitBucket, Tag 'Inicial'
----------------------------------------------------------------------------------------------------------------------------------------------

	$ cd ~fred/workspace
	$ git clone --branch Inicial https://fredguedespereira@bitbucket.org/fredguedespereira/memoriam-jsf.git


2. Definir um template
----------------------------------------------------------------------------------------------------------------------------------------------

	$ cd ~fred/workspace/memoriam-jsf/src/main/webapp
	$ md template
	$ cd template
	$ touch _template.xhtml
	$ touch _header.xhtml

Observar:
* O uso de biblioteca de recursos do JSF 2
* Alteração do arquivo bootstrap.css nas URLs das fonts
* Uso de ui:include
* Uso de ui?component para incluir um fragmento de código xhtml em outro, sem que o exterior seja removido.

	$ cd ~fred/workspace/memoriam-jsf/src/main/webapp
	$ touch index.xhtml


3. Implementar tela de login com bootstrap
----------------------------------------------------------------------------------------------------------------------------------------------

	$ cd ~fred/workspace/memoriam-jsf/src/main/webapp/login
	$ touch login.xhtml


4. Implemente o LoginBean
----------------------------------------------------------------------------------------------------------------------------------------------

	$ cd ~fred/workspace/memoriam-jsf/src/main/java
	$ md br/edu/ifpb/pweb/bean
	$ cd br/edu/ifpb/pweb/bean
	$ touch LoginBean.java

Observar:
* O método addMessage() foi extraído do código
* Mudou-se o valor da proxView para ver o efeito sobre o ViewScoped
* Mudou-se o método addMessage() para manter as mensagens no Flash
		
		
5. Implementação da tela de consulta de contatos/consulta
----------------------------------------------------------------------------------------------------------------------------------------------

	$ cd ~fred/workspace/memoriam-jsf/src/main/webapp/contato
	$ touch consulta.xhtml
	
	$ cd ~fred/workspace/memoriam-jsf/src/main/java
	$ cd br.edu.ifpb.pweb/bean
	$ touch ConsultaBean.java
	
Observações:

* Adiciona a dependência do PrimeFaces no pom.xml:
	<repositories>
		<repository>
			<id>prime-repo</id>
			<name>PrimeFaces Maven Repository</name>
			<url>http://repository.primefaces.org</url>
			<layout>default</layout>
		</repository>
	</repositories>

	<dependency>
		<groupId>org.primefaces</groupId>
		<artifactId>primefaces</artifactId>
		<version>5.3</version>
	</dependency>		
* Modifica o escopo do LoginBean para Session
* Adiciona uma propriedade usuarioLogado e a usa quando consultar o banco
* Modifica a próximaView
* Altera o _header.xhtml para usar o LoginBean
	
6. Implementação da tela de cadastro de contato
----------------------------------------------------------------------------------------------------------------------------------------------

	$ cd ~fred/workspace/memoriam-jsf/src/main/webapp/contato
	$ touch cadastro.xhtml
	$ cd ~fred/workspace/memoriam-jsf/src/main/webapp/
	$ md br.edu.ifpb.pweb/converter
	$ touch OperadoraConverter
		
Observações:

* Copiar as classes de apoio ao selectOneMenu
* Criar a classe conversora de operadoras
* Ajustar o LoginBean para não exibir mensagem de sucesso
* Modificar a classe ContatoController e o método cadastrar()
* Implementar o método salvar() no ContatoBean
* Implementar o UtilBean que carrega previsamente as operadoras para o combobox
* Copiar o método addMessagem() de LoginBean para ContatoBean
* Mostrar a futura classe GenericBean com coisas comuns a todos os beans.
		
$ cd ~fred/workspace/memoriam-jsf/src/main/webapp
