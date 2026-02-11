<img width="122" height="130" alt="image" src="https://github.com/user-attachments/assets/f8262c4f-da00-4ca8-bcc4-f773b03202c0" />

## Descrição

CarsExplorer é um aplicativo Android simples que permite aos usuários explorar uma lista de fabricantes de automóveis e seus respectivos modelos. O aplicativo busca dados de uma API remota e os armazena localmente para permitir a visualização offline.

## Funcionalidades

*   Visualizar uma lista de fabricantes de automóveis.
*   Selecionar um fabricante para ver a lista de seus modelos.
*   Suporte offline para dados já carregados.
*   Interface de usuário limpa e simples.
*   Exibição de mensagens amigáveis quando não há conexão ou dados.

## Tecnologias Utilizadas

*   **Linguagem:** [Kotlin](https://kotlinlang.org/)
*   **Arquitetura:** MVVM (Model-View-ViewModel)
*   **API:** [NHTSA](https://vpic.nhtsa.dot.gov/api/)
*   **Injeção de Dependência:** [Hilt](https://dagger.dev/hilt/)
*   **Componentes do Jetpack:**
    *   [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) - Para navegação entre as telas.
    *   [Room](https://developer.android.com/training/data-storage/room) - Para persistência de dados e suporte offline.
    *   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Para gerenciar dados relacionados à UI de forma consciente do ciclo de vida.
    *   [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Para interagir com as views de forma segura.
*   **Networking:**
    *   [Retrofit](https://square.github.io/retrofit/) - Para requisições HTTP à API.
    *   [OkHttp](https://square.github.io/okhttp/) - Como cliente HTTP para o Retrofit.
*   **UI:**
    *   [Material Components](https://material.io/develop/android)
    *   RecyclerView

## Como Compilar e Executar

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/lukninja97/CarsExplorer.git
    ```
2.  **Abra no Android Studio:**
    *   Inicie o Android Studio.
    *   Selecione "Open an existing Android Studio project".
    *   Navegue até o diretório clonado e selecione-o.
3.  **Sincronize e Compile:**
    *   Aguarde o Android Studio sincronizar o projeto com os arquivos Gradle.
    *   Execute o aplicativo em um emulador ou dispositivo físico.
4.  **Ambiente de teste**
    * **Dispositivo:** Emulador Pixel 8
    *  **API do Android:** 36 (Baklava)
    *  **Android Studio:** Otter 2 Feature Drop | 2025.2.2

## Screenshots

### SplashScreen
<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/a07b2bd0-8bce-4f14-b98e-b3b8fa6f9efa" />

### Lista de Marcas
<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/446b5bbf-479c-401d-84bf-ffd7b2f208e7" />

### Lista de Fabricantes
<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/2a786072-d6ef-4a23-a0db-54bd8d6273f0" />

### Detalhes do fabricante
<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/858f7758-fcd1-4198-a9d5-e61309f0a31f" />

### Tela de aviso
<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/656620ef-1f83-4219-a8c0-35ee437bcfd5" />


---
