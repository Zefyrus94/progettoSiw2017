package it.uniroma3.spring.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;

	@Autowired
	private RedirectLoginSuccessHandler loginSuccessHandler;

	@Autowired
	private RedirectLogoutSuccessHandler logoutSuccessHandler;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>
    inMemoryConfigurer() {
	return new InMemoryUserDetailsManagerConfigurer<>();
}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		inMemoryConfigurer()
        .withUser("admin")
            .password("admin")
            .authorities("ROLE_ADMIN")
.and().configure(auth);
auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT username, password, 1 FROM utenti WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT u.username, ruoli.ruolo authority " +
				"FROM utenti u JOIN ruoli_utente ruoli ON u.id = ruoli.utente_id WHERE u.username = ?");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT username, password, 1 FROM utenti WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT u.username, ruoli.ruolo authority " +
				"FROM utenti u JOIN ruoli_utente ruoli ON u.id = ruoli.utente_id WHERE u.username = ?");
	}
//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//	    return new EmbeddedServletContainerCustomizer() {
//	        @Override
//	        public void customize(ConfigurableEmbeddedServletContainer container) {
//	            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//	        }
//	    };
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.formLogin()
		.loginPage("/accedi")
		.permitAll()
		.successHandler(loginSuccessHandler)
		.and()
		.authorizeRequests()
		.antMatchers("/", "/accesso", "/logout", "../css/**", "../js/**","/log_admin","/accessoadmin").permitAll()
		.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.logout().permitAll()
		.logoutSuccessHandler(logoutSuccessHandler);
	}


}
