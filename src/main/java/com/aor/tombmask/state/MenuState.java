package com.aor.tombmask.state;


import com.aor.tombmask.controller.AbstractController;
import com.aor.tombmask.controller.MenuController;
import com.aor.tombmask.model.Menu;
import com.aor.tombmask.state.AbstractState;
import com.aor.tombmask.view.AbstractView;
import com.aor.tombmask.view.MainMenuView;

public class MenuState extends AbstractState<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    public AbstractView<Menu> getEspecificViewer() {
        return new MainMenuView(getModel());
    }

    @Override
    public AbstractController<Menu> getEspecificController() {
        return new MenuController(getModel());
    }
}