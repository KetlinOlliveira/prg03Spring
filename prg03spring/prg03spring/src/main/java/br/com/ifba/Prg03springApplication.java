package br.com.ifba;

import br.com.ifba.curso.view.TelaPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;
import br.com.ifba.curso.controller.CursoController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import br.com.ifba.curso.controller.CursoIController;
    



@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(// Esta parte configura o comportamento padrão do @ComponentScan.       
    type = FilterType.ASSIGNABLE_TYPE, // Define o tipo de filtro. ASSIGNABLE_TYPE significa que a exclusão é baseada
    // no tipo da classe (class-based).
    value = br.com.ifba.curso.view.TelaPrincipal.class// Especifica a CLASSE exata que deve ser excluída da varredura de componentes.
))
public class Prg03springApplication {

	public static void main(String[] args) {
            
         ConfigurableApplicationContext context = new SpringApplicationBuilder(Prg03springApplication.class)
        // Garante que o ambiente AWT (base do Swing) não esteja em modo "headless" (sem tela).
        .headless(false) 
        // Inicia o contexto.
        .run(args); 

    //Obtém o Controller injetado
    CursoIController controller = context.getBean(CursoController.class); 

    // Inicializa sua TelaPrincipal no thread seguro do Swing (EDT).
    // O EDT mantém a JVM viva mesmo após o main() terminar.
    javax.swing.SwingUtilities.invokeLater(() -> {
        // Cria a tela, passando o Controller.
        TelaPrincipal tela = new TelaPrincipal(controller);
        tela.setVisible(true);
       
        
    });
		
	}

}
