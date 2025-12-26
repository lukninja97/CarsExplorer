# 🚗 CarsExplorer

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

### Lista de Marcas

### Lista de Fabricantes

### Detalhes do fabricante

---
