package org.oasystem_dazhu.mvp.presenter;


import org.oasystem_dazhu.mvp.view.baseDelegate.IDelegate;

/**
 * Created by www on 2017/5/5.
 */
public interface IPresenter<T extends IDelegate> {

    Class<T> getDelegateClass();
}